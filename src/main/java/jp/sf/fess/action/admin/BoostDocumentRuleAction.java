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

package jp.sf.fess.action.admin;

import java.sql.Timestamp;

import javax.annotation.Resource;

import jp.sf.fess.crud.CommonConstants;
import jp.sf.fess.crud.CrudMessageException;
import jp.sf.fess.crud.action.admin.BsBoostDocumentRuleAction;
import jp.sf.fess.crud.util.SAStrutsUtil;
import jp.sf.fess.db.exentity.BoostDocumentRule;
import jp.sf.fess.helper.SystemHelper;
import jp.sf.fess.util.FessBeans;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelibs.sastruts.core.exception.SSCActionMessagesException;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.exception.ActionMessagesException;

public class BoostDocumentRuleAction extends BsBoostDocumentRuleAction {

    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory
            .getLog(BoostDocumentRuleAction.class);

    @Resource
    protected SystemHelper systemHelper;

    public String getHelpLink() {
        return systemHelper.getHelpLink("boostDocumentRule");
    }

    @Override
    protected void loadBoostDocumentRule() {

        final BoostDocumentRule boostDocumentRule = boostDocumentRuleService
                .getBoostDocumentRule(createKeyMap());
        if (boostDocumentRule == null) {
            // throw an exception
            throw new SSCActionMessagesException(
                    "errors.crud_could_not_find_crud_table",
                    new Object[] { boostDocumentRuleForm.id });
        }

        FessBeans.copy(boostDocumentRule, boostDocumentRuleForm)
                .commonColumnDateConverter().excludes("searchParams", "mode")
                .execute();
    }

    @Override
    protected BoostDocumentRule createBoostDocumentRule() {
        BoostDocumentRule boostDocumentRule;
        final String username = systemHelper.getUsername();
        final Timestamp timestamp = systemHelper.getCurrentTimestamp();
        if (boostDocumentRuleForm.crudMode == CommonConstants.EDIT_MODE) {
            boostDocumentRule = boostDocumentRuleService
                    .getBoostDocumentRule(createKeyMap());
            if (boostDocumentRule == null) {
                // throw an exception
                throw new SSCActionMessagesException(
                        "errors.crud_could_not_find_crud_table",
                        new Object[] { boostDocumentRuleForm.id });
            }
        } else {
            boostDocumentRule = new BoostDocumentRule();
            boostDocumentRule.setCreatedBy(username);
            boostDocumentRule.setCreatedTime(timestamp);
        }
        boostDocumentRule.setUpdatedBy(username);
        boostDocumentRule.setUpdatedTime(timestamp);
        FessBeans.copy(boostDocumentRuleForm, boostDocumentRule)
                .excludesCommonColumns().execute();

        return boostDocumentRule;
    }

    @Override
    @Execute(validator = false, input = "error.jsp")
    public String delete() {
        if (boostDocumentRuleForm.crudMode != CommonConstants.DELETE_MODE) {
            throw new SSCActionMessagesException("errors.crud_invalid_mode",
                    new Object[] { CommonConstants.DELETE_MODE,
                            boostDocumentRuleForm.crudMode });
        }

        try {
            final BoostDocumentRule boostDocumentRule = boostDocumentRuleService
                    .getBoostDocumentRule(createKeyMap());
            if (boostDocumentRule == null) {
                // throw an exception
                throw new SSCActionMessagesException(
                        "errors.crud_could_not_find_crud_table",
                        new Object[] { boostDocumentRuleForm.id });
            }

            //           boostDocumentRuleService.delete(boostDocumentRule);
            final String username = systemHelper.getUsername();
            final Timestamp timestamp = systemHelper.getCurrentTimestamp();
            boostDocumentRule.setDeletedBy(username);
            boostDocumentRule.setDeletedTime(timestamp);
            boostDocumentRuleService.store(boostDocumentRule);
            SAStrutsUtil.addSessionMessage("success.crud_delete_crud_table");

            return displayList(true);
        } catch (final ActionMessagesException e) {
            log.error(e.getMessage(), e);
            throw e;
        } catch (final CrudMessageException e) {
            log.error(e.getMessage(), e);
            throw new SSCActionMessagesException(e, e.getMessageId(),
                    e.getArgs());
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
            throw new SSCActionMessagesException(e,
                    "errors.crud_failed_to_delete_crud_table");
        }
    }
}
