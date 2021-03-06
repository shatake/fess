/*
 * Copyright 2009-2014 the CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package jp.sf.fess.helper.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import jp.sf.fess.Constants;
import jp.sf.fess.db.cbean.SearchLogCB;
import jp.sf.fess.db.cbean.UserInfoCB;
import jp.sf.fess.db.exbhv.ClickLogBhv;
import jp.sf.fess.db.exbhv.SearchLogBhv;
import jp.sf.fess.db.exbhv.UserInfoBhv;
import jp.sf.fess.db.exentity.ClickLog;
import jp.sf.fess.db.exentity.SearchFieldLog;
import jp.sf.fess.db.exentity.SearchLog;
import jp.sf.fess.db.exentity.UserInfo;
import jp.sf.fess.helper.DocumentHelper;
import jp.sf.fess.helper.FieldHelper;
import jp.sf.fess.helper.SearchLogHelper;
import jp.sf.fess.service.SearchLogService;
import jp.sf.fess.service.UserInfoService;
import jp.sf.fess.util.ComponentUtil;
import jp.sf.fess.util.FessBeans;

import org.codelibs.core.util.StringUtil;
import org.seasar.framework.container.SingletonS2Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchLogHelperImpl extends SearchLogHelper {
    private static final Logger logger = LoggerFactory // NOPMD
            .getLogger(SearchLogHelperImpl.class);

    @Override
    public void updateUserInfo(final String userCode) {
        final long current = System.currentTimeMillis();
        final Long time = userInfoCache.get(userCode);
        if (time == null || current - time.longValue() > userCheckInterval) {
            final UserInfoService userInfoService = SingletonS2Container
                    .getComponent(UserInfoService.class);
            UserInfo userInfo = userInfoService.getUserInfo(userCode);
            if (userInfo == null) {
                final Timestamp now = new Timestamp(current);
                userInfo = new UserInfo();
                userInfo.setCode(userCode);
                userInfo.setCreatedTime(now);
                userInfo.setUpdatedTime(now);
                userInfoService.store(userInfo);
            }
            userInfoCache.put(userCode, current);
        }
    }

    @Override
    protected void processSearchLogQueue(final Queue<SearchLog> queue) {
        final List<SearchLog> searchLogList = new ArrayList<SearchLog>();
        final String value = crawlerProperties.getProperty(
                Constants.PURGE_BY_BOTS_PROPERTY, StringUtil.EMPTY);
        String[] botNames;
        if (StringUtil.isBlank(value)) {
            botNames = StringUtil.EMPTY_STRINGS;
        } else {
            botNames = value.split(",");
        }

        final boolean suggestAvailable = Constants.TRUE
                .equals(crawlerProperties.getProperty(
                        Constants.SUGGEST_SEARCH_LOG_PROPERTY, Constants.TRUE));
        final String dayForCleanupStr = crawlerProperties.getProperty(
                Constants.PURGE_SUGGEST_SEARCH_LOG_DAY_PROPERTY, "30");
        int dayForCleanup = -1;
        try {
            dayForCleanup = Integer.parseInt(dayForCleanupStr);
        } catch (final NumberFormatException e) {
        }

        boolean addedSuggest = false;
        final Map<String, UserInfo> userInfoMap = new HashMap<String, UserInfo>();
        for (final SearchLog searchLog : queue) {
            boolean add = true;
            for (final String botName : botNames) {
                if (searchLog.getUserAgent() != null
                        && searchLog.getUserAgent().indexOf(botName) >= 0) {
                    add = false;
                    break;
                }
            }
            if (add) {
                final UserInfo userInfo = searchLog.getUserInfo();
                if (userInfo != null) {
                    final String code = userInfo.getCode();
                    final UserInfo oldUserInfo = userInfoMap.get(code);
                    if (oldUserInfo != null) {
                        userInfo.setCreatedTime(oldUserInfo.getCreatedTime());
                    }
                    userInfoMap.put(code, userInfo);
                }
                searchLogList.add(searchLog);

                if (suggestAvailable && searchLog.getHitCount() > 0) {
                    final List<SearchFieldLog> searchFieldLogList = searchLog
                            .getSearchFieldLogList();
                    for (final SearchFieldLog searchFieldLog : searchFieldLogList) {
                        if ("solrQuery".equals(searchFieldLog.getName())) {
                            suggestService.addSolrParams(
                                    searchFieldLog.getValue(), dayForCleanup);
                            addedSuggest = true;
                        }
                    }
                }
            }
        }
        if (addedSuggest) {
            suggestService.commit();
        }

        if (!userInfoMap.isEmpty()) {
            final List<UserInfo> insertList = new ArrayList<UserInfo>(
                    userInfoMap.values());
            final List<UserInfo> updateList = new ArrayList<UserInfo>();
            final UserInfoCB cb = new UserInfoCB();
            cb.query().setCode_InScope(userInfoMap.keySet());
            final UserInfoBhv userInfoBhv = SingletonS2Container
                    .getComponent(UserInfoBhv.class);
            final List<UserInfo> list = userInfoBhv.selectList(cb);
            for (final UserInfo userInfo : list) {
                final String code = userInfo.getCode();
                final UserInfo entity = userInfoMap.get(code);
                FessBeans.copy(userInfo, entity).includes("id", "createdTime")
                        .execute();
                updateList.add(entity);
                insertList.remove(entity);
            }
            userInfoBhv.batchInsert(insertList);
            userInfoBhv.batchUpdate(updateList);
            for (final SearchLog searchLog : searchLogList) {
                final UserInfo userInfo = searchLog.getUserInfo();
                if (userInfo != null) {
                    final UserInfo entity = userInfoMap.get(userInfo.getCode());
                    searchLog.setUserId(entity.getId());
                }
            }
        }

        if (!searchLogList.isEmpty()) {
            final SearchLogService searchLogService = SingletonS2Container
                    .getComponent(SearchLogService.class);
            searchLogService.store(searchLogList);
        }
    }

    @Override
    protected void processClickLogQueue(final Queue<ClickLog> queue) {
        final Map<String, Long> clickCountMap = new HashMap<String, Long>();
        final List<ClickLog> clickLogList = new ArrayList<ClickLog>();
        for (final ClickLog clickLog : queue) {
            try {
                final SearchLogCB cb = new SearchLogCB();
                cb.query().setRequestedTime_Equal(
                        clickLog.getQueryRequestedTime());
                cb.query().setUserSessionId_Equal(clickLog.getUserSessionId());
                final SearchLogBhv searchLogBhv = SingletonS2Container
                        .getComponent(SearchLogBhv.class);
                final SearchLog entity = searchLogBhv.selectEntity(cb);
                if (entity != null) {
                    clickLog.setSearchId(entity.getId());
                    clickLogList.add(clickLog);
                } else {
                    logger.warn("Not Found[ClickLog]: " + clickLog);
                }

                final String docId = clickLog.getDocId();
                Long countObj = clickCountMap.get(docId);
                final long clickCount = clickLog.getClickCount();
                if (countObj == null) {
                    countObj = Long.valueOf(clickCount);
                } else {
                    countObj = Math.max(countObj.longValue(), clickCount) + 1;
                }
                clickCountMap.put(docId, countObj);
            } catch (final Exception e) {
                logger.warn("Failed to process: " + clickLog, e);
            }
        }
        if (!clickLogList.isEmpty()) {
            try {
                final ClickLogBhv clickLogBhv = SingletonS2Container
                        .getComponent(ClickLogBhv.class);
                clickLogBhv.batchInsert(clickLogList);
            } catch (final Exception e) {
                logger.warn("Failed to insert: " + clickLogList, e);
            }
        }

        final DocumentHelper documentHelper = ComponentUtil.getDocumentHelper();
        final FieldHelper fieldHelper = ComponentUtil.getFieldHelper();
        for (final Map.Entry<String, Long> entry : clickCountMap.entrySet()) {
            try {
                documentHelper.update(entry.getKey(),
                        fieldHelper.clickCountField, entry.getValue() + 1);
            } catch (final Exception e) {
                logger.warn("Failed to update a clickCount(" + entry.getValue()
                        + ") for " + entry.getKey(), e);
            }
        }
    }
}
