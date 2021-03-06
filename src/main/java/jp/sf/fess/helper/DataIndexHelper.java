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

package jp.sf.fess.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jp.sf.fess.Constants;
import jp.sf.fess.db.exentity.DataCrawlingConfig;
import jp.sf.fess.ds.DataStore;
import jp.sf.fess.ds.DataStoreFactory;
import jp.sf.fess.ds.IndexUpdateCallback;
import jp.sf.fess.service.DataCrawlingConfigService;
import jp.sf.fess.util.ComponentUtil;

import org.codelibs.core.util.DynamicProperties;
import org.codelibs.solr.lib.SolrGroup;
import org.seasar.framework.container.SingletonS2Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataIndexHelper implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory
            .getLogger(DataIndexHelper.class);

    @Resource
    protected DynamicProperties crawlerProperties;

    @Resource
    public DataCrawlingConfigService dataCrawlingConfigService;

    @Resource
    protected CrawlingConfigHelper crawlingConfigHelper;

    public long crawlingExecutionInterval = Constants.DEFAULT_CRAWLING_EXECUTION_INTERVAL;

    public int crawlerPriority = Thread.NORM_PRIORITY;

    private final List<DataCrawlingThread> dataCrawlingThreadList = Collections
            .synchronizedList(new ArrayList<DataCrawlingThread>());

    public void crawl(final String sessionId, final SolrGroup solrGroup) {
        final List<DataCrawlingConfig> configList = dataCrawlingConfigService
                .getAllDataCrawlingConfigList();

        if (configList.isEmpty()) {
            // nothing
            if (logger.isInfoEnabled()) {
                logger.info("No crawling target data.");
            }
            return;
        }

        crawl(sessionId, solrGroup, configList);
    }

    public void crawl(final String sessionId, final List<Long> configIdList,
            final SolrGroup solrGroup) {
        final List<DataCrawlingConfig> configList = dataCrawlingConfigService
                .getDataCrawlingConfigListByIds(configIdList);

        if (configList.isEmpty()) {
            // nothing
            if (logger.isInfoEnabled()) {
                logger.info("No crawling target urls.");
            }
            return;
        }

        crawl(sessionId, solrGroup, configList);
    }

    protected void crawl(final String sessionId, final SolrGroup solrGroup,
            final List<DataCrawlingConfig> configList) {
        int multiprocessCrawlingCount = 5;
        String value = crawlerProperties.getProperty(
                Constants.CRAWLING_THREAD_COUNT_PROPERTY, "5");
        try {
            multiprocessCrawlingCount = Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            // NOP
        }

        long commitPerCount = Constants.DEFAULT_COMMIT_PER_COUNT;
        value = crawlerProperties.getProperty(
                Constants.COMMIT_PER_COUNT_PROPERTY,
                Long.toString(Constants.DEFAULT_COMMIT_PER_COUNT));
        try {
            commitPerCount = Long.parseLong(value);
        } catch (final NumberFormatException e) {
            // NOP
        }

        final long startTime = System.currentTimeMillis();

        final IndexUpdateCallback indexUpdateCallback = SingletonS2Container
                .getComponent(IndexUpdateCallback.class);
        indexUpdateCallback.setSolrGroup(solrGroup);
        indexUpdateCallback.setCommitPerCount(commitPerCount);

        final List<String> sessionIdList = new ArrayList<String>();
        final Map<String, String> initParamMap = new HashMap<String, String>();
        dataCrawlingThreadList.clear();
        final List<String> dataCrawlingThreadStatusList = new ArrayList<String>();
        for (final DataCrawlingConfig dataCrawlingConfig : configList) {
            final String sid = crawlingConfigHelper.store(sessionId,
                    dataCrawlingConfig);
            sessionIdList.add(sid);

            initParamMap.put(Constants.SESSION_ID, sessionId);
            initParamMap.put("crawlingSessionId", sid);

            final DataCrawlingThread dataCrawlingThread = new DataCrawlingThread(
                    dataCrawlingConfig, indexUpdateCallback, initParamMap);
            dataCrawlingThread.setPriority(crawlerPriority);
            dataCrawlingThread.setName(sid);
            dataCrawlingThread.setDaemon(true);

            dataCrawlingThreadList.add(dataCrawlingThread);
            dataCrawlingThreadStatusList.add(Constants.READY);

        }

        final SystemHelper systemHelper = ComponentUtil.getSystemHelper();

        int startedCrawlerNum = 0;
        int activeCrawlerNum = 0;
        while (startedCrawlerNum < dataCrawlingThreadList.size()) {
            // Force to stop crawl
            if (systemHelper.isForceStop()) {
                for (final DataCrawlingThread s2Robot : dataCrawlingThreadList) {
                    s2Robot.stopCrawling();
                }
                break;
            }

            if (activeCrawlerNum < multiprocessCrawlingCount) {
                // start crawling
                dataCrawlingThreadList.get(startedCrawlerNum).start();
                dataCrawlingThreadStatusList.set(startedCrawlerNum,
                        Constants.RUNNING);
                startedCrawlerNum++;
                activeCrawlerNum++;
                try {
                    Thread.sleep(crawlingExecutionInterval);
                } catch (final InterruptedException e) {
                    // NOP
                }
                continue;
            }

            // check status
            for (int i = 0; i < startedCrawlerNum; i++) {
                if (!dataCrawlingThreadList.get(i).isRunning()
                        && dataCrawlingThreadStatusList.get(i).equals(
                                Constants.RUNNING)) {
                    dataCrawlingThreadList.get(i).awaitTermination();
                    dataCrawlingThreadStatusList.set(i, Constants.DONE);
                    activeCrawlerNum--;
                }
            }
            try {
                Thread.sleep(crawlingExecutionInterval);
            } catch (final InterruptedException e) {
                // NOP
            }
        }

        boolean finishedAll = false;
        while (!finishedAll) {
            finishedAll = true;
            for (int i = 0; i < dataCrawlingThreadList.size(); i++) {
                dataCrawlingThreadList.get(i).awaitTermination(
                        crawlingExecutionInterval);
                if (!dataCrawlingThreadList.get(i).isRunning()
                        && dataCrawlingThreadStatusList.get(i).equals(
                                Constants.RUNNING)) {
                    dataCrawlingThreadStatusList.set(i, Constants.DONE);
                }
                if (!dataCrawlingThreadStatusList.get(i).equals(Constants.DONE)) {
                    finishedAll = false;
                }
            }
        }
        dataCrawlingThreadList.clear();
        dataCrawlingThreadStatusList.clear();

        indexUpdateCallback.commit();

        // put cralwing info
        final CrawlingSessionHelper crawlingSessionHelper = ComponentUtil
                .getCrawlingSessionHelper();

        final long execTime = System.currentTimeMillis() - startTime;
        crawlingSessionHelper.putToInfoMap(Constants.DATA_CRAWLING_EXEC_TIME,
                Long.toString(execTime));
        if (logger.isInfoEnabled()) {
            logger.info("[EXEC TIME] crawling time: " + execTime + "ms");
        }

        crawlingSessionHelper.putToInfoMap(Constants.DATA_INDEX_EXEC_TIME,
                Long.toString(indexUpdateCallback.getExecuteTime()));
        crawlingSessionHelper.putToInfoMap(Constants.DATA_INDEX_SIZE,
                Long.toString(indexUpdateCallback.getDocumentSize()));

        for (final String sid : sessionIdList) {
            // remove config
            crawlingConfigHelper.remove(sid);
        }

    }

    protected static class DataCrawlingThread extends Thread {

        private final DataCrawlingConfig dataCrawlingConfig;

        private final IndexUpdateCallback indexUpdateCallback;

        private final Map<String, String> initParamMap;

        protected boolean finished = false;

        protected boolean running = false;

        private DataStore dataStore;

        protected DataCrawlingThread(
                final DataCrawlingConfig dataCrawlingConfig,
                final IndexUpdateCallback indexUpdateCallback,
                final Map<String, String> initParamMap) {
            this.dataCrawlingConfig = dataCrawlingConfig;
            this.indexUpdateCallback = indexUpdateCallback;
            this.initParamMap = initParamMap;
        }

        @Override
        public void run() {
            running = true;
            final DataStoreFactory dataStoreFactory = ComponentUtil
                    .getDataStoreFactory();
            dataStore = dataStoreFactory.getDataStore(dataCrawlingConfig
                    .getHandlerName());
            if (dataStore == null) {
                logger.error("DataStore(" + dataCrawlingConfig.getHandlerName()
                        + ") is not found.");
            } else {
                try {
                    dataStore.store(dataCrawlingConfig, indexUpdateCallback,
                            initParamMap);
                } catch (final Exception e) {
                    logger.error("Failed to process a data crawling: "
                            + dataCrawlingConfig.getName(), e);
                }
            }
            running = false;
            finished = true;
        }

        public boolean isFinished() {
            return finished;
        }

        public void stopCrawling() {
            if (dataStore != null) {
                dataStore.stop();
            }
        }

        public String getCrawlingSessionId() {
            return initParamMap.get("crawlingSessionId");
        }

        public boolean isRunning() {
            return running;
        }

        public void awaitTermination() {
            try {
                join();
            } catch (final InterruptedException e) {
            }
        }

        public void awaitTermination(final long mills) {
            try {
                join(mills);
            } catch (final InterruptedException e) {
            }
        }
    }
}
