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

package jp.sf.fess.crud.action.admin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jp.sf.fess.crud.CommonConstants;
import jp.sf.fess.crud.CrudMessageException;
import jp.sf.fess.crud.util.SAStrutsUtil;
import jp.sf.fess.db.exentity.BoostDocumentRule;
import jp.sf.fess.form.admin.BoostDocumentRuleForm;
import jp.sf.fess.pager.BoostDocumentRulePager;
import jp.sf.fess.service.BoostDocumentRuleService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codelibs.sastruts.core.annotation.Token;
import org.seasar.framework.beans.util.Beans;
import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.exception.ActionMessagesException;

public class BsBoostDocumentRuleAction implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory
            .getLog(BsBoostDocumentRuleAction.class);

    // for list

    public List<BoostDocumentRule> boostDocumentRuleItems;

    // for edit/confirm/delete

    @ActionForm
    @Resource
    protected BoostDocumentRuleForm boostDocumentRuleForm;

    @Resource
    protected BoostDocumentRuleService boostDocumentRuleService;

    @Resource
    protected BoostDocumentRulePager boostDocumentRulePager;

    protected String displayList(final boolean redirect) {
        // page navi
        boostDocumentRuleItems = boostDocumentRuleService
                .getBoostDocumentRuleList(boostDocumentRulePager);

        // restore from pager
        Beans.copy(boostDocumentRulePager, boostDocumentRuleForm.searchParams)
                .excludes(CommonConstants.PAGER_CONVERSION_RULE)

                .execute();

        if (redirect) {
            return "index?redirect=true";
        } else {
            return "index.jsp";
        }
    }

    @Execute(validator = false, input = "error.jsp")
    public String index() {
        return displayList(false);
    }

    @Execute(validator = false, input = "error.jsp", urlPattern = "list/{pageNumber}")
    public String list() {
        // page navi
        if (StringUtil.isNotBlank(boostDocumentRuleForm.pageNumber)) {
            try {
                boostDocumentRulePager.setCurrentPageNumber(Integer
                        .parseInt(boostDocumentRuleForm.pageNumber));
            } catch (final NumberFormatException e) {
                if (log.isDebugEnabled()) {
                    log.debug("Invalid value: "
                            + boostDocumentRuleForm.pageNumber, e);
                }
            }
        }

        return displayList(false);
    }

    @Execute(validator = false, input = "error.jsp")
    public String search() {
        Beans.copy(boostDocumentRuleForm.searchParams, boostDocumentRulePager)
                .excludes(CommonConstants.PAGER_CONVERSION_RULE)

                .execute();

        return displayList(false);
    }

    @Execute(validator = false, input = "error.jsp")
    public String reset() {
        boostDocumentRulePager.clear();

        return displayList(false);
    }

    @Execute(validator = false, input = "error.jsp")
    public String back() {
        return displayList(false);
    }

    @Token(save = true, validate = false)
    @Execute(validator = false, input = "error.jsp")
    public String editagain() {
        return "edit.jsp";
    }

    @Execute(validator = false, input = "error.jsp", urlPattern = "confirmpage/{crudMode}/{id}")
    public String confirmpage() {
        if (boostDocumentRuleForm.crudMode != CommonConstants.CONFIRM_MODE) {
            throw new ActionMessagesException("errors.crud_invalid_mode",
                    new Object[] { CommonConstants.CONFIRM_MODE,
                            boostDocumentRuleForm.crudMode });
        }

        loadBoostDocumentRule();

        return "confirm.jsp";
    }

    @Token(save = true, validate = false)
    @Execute(validator = false, input = "error.jsp")
    public String createpage() {
        // page navi
        boostDocumentRuleForm.initialize();
        boostDocumentRuleForm.crudMode = CommonConstants.CREATE_MODE;

        return "edit.jsp";
    }

    @Token(save = true, validate = false)
    @Execute(validator = false, input = "error.jsp", urlPattern = "editpage/{crudMode}/{id}")
    public String editpage() {
        if (boostDocumentRuleForm.crudMode != CommonConstants.EDIT_MODE) {
            throw new ActionMessagesException("errors.crud_invalid_mode",
                    new Object[] { CommonConstants.EDIT_MODE,
                            boostDocumentRuleForm.crudMode });
        }

        loadBoostDocumentRule();

        return "edit.jsp";
    }

    @Token(save = true, validate = false)
    @Execute(validator = false, input = "error.jsp")
    public String editfromconfirm() {
        boostDocumentRuleForm.crudMode = CommonConstants.EDIT_MODE;

        loadBoostDocumentRule();

        return "edit.jsp";
    }

    @Token(save = false, validate = true, keep = true)
    @Execute(validator = true, input = "edit.jsp")
    public String confirmfromcreate() {
        return "confirm.jsp";
    }

    @Token(save = false, validate = true, keep = true)
    @Execute(validator = true, input = "edit.jsp")
    public String confirmfromupdate() {
        return "confirm.jsp";
    }

    @Token(save = true, validate = false)
    @Execute(validator = false, input = "error.jsp", urlPattern = "deletepage/{crudMode}/{id}")
    public String deletepage() {
        if (boostDocumentRuleForm.crudMode != CommonConstants.DELETE_MODE) {
            throw new ActionMessagesException("errors.crud_invalid_mode",
                    new Object[] { CommonConstants.DELETE_MODE,
                            boostDocumentRuleForm.crudMode });
        }

        loadBoostDocumentRule();

        return "confirm.jsp";
    }

    @Token(save = true, validate = false)
    @Execute(validator = false, input = "error.jsp")
    public String deletefromconfirm() {
        boostDocumentRuleForm.crudMode = CommonConstants.DELETE_MODE;

        loadBoostDocumentRule();

        return "confirm.jsp";
    }

    @Token(save = false, validate = true)
    @Execute(validator = true, input = "edit.jsp")
    public String create() {
        try {
            final BoostDocumentRule boostDocumentRule = createBoostDocumentRule();
            boostDocumentRuleService.store(boostDocumentRule);
            SAStrutsUtil.addSessionMessage("success.crud_create_crud_table");

            return displayList(true);
        } catch (final ActionMessagesException e) {
            log.error(e.getMessage(), e);
            throw e;
        } catch (final CrudMessageException e) {
            log.error(e.getMessage(), e);
            throw new ActionMessagesException(e.getMessageId(), e.getArgs());
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
            throw new ActionMessagesException(
                    "errors.crud_failed_to_create_crud_table");
        }
    }

    @Token(save = false, validate = true)
    @Execute(validator = true, input = "edit.jsp")
    public String update() {
        try {
            final BoostDocumentRule boostDocumentRule = createBoostDocumentRule();
            boostDocumentRuleService.store(boostDocumentRule);
            SAStrutsUtil.addSessionMessage("success.crud_update_crud_table");

            return displayList(true);
        } catch (final ActionMessagesException e) {
            log.error(e.getMessage(), e);
            throw e;
        } catch (final CrudMessageException e) {
            log.error(e.getMessage(), e);
            throw new ActionMessagesException(e.getMessageId(), e.getArgs());
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
            throw new ActionMessagesException(
                    "errors.crud_failed_to_update_crud_table");
        }
    }

    @Token(save = false, validate = true)
    @Execute(validator = false, input = "error.jsp")
    public String delete() {
        if (boostDocumentRuleForm.crudMode != CommonConstants.DELETE_MODE) {
            throw new ActionMessagesException("errors.crud_invalid_mode",
                    new Object[] { CommonConstants.DELETE_MODE,
                            boostDocumentRuleForm.crudMode });
        }

        try {
            final BoostDocumentRule boostDocumentRule = boostDocumentRuleService
                    .getBoostDocumentRule(createKeyMap());
            if (boostDocumentRule == null) {
                // throw an exception
                throw new ActionMessagesException(
                        "errors.crud_could_not_find_crud_table",

                        new Object[] { boostDocumentRuleForm.id });

            }

            boostDocumentRuleService.delete(boostDocumentRule);
            SAStrutsUtil.addSessionMessage("success.crud_delete_crud_table");

            return displayList(true);
        } catch (final ActionMessagesException e) {
            log.error(e.getMessage(), e);
            throw e;
        } catch (final CrudMessageException e) {
            log.error(e.getMessage(), e);
            throw new ActionMessagesException(e.getMessageId(), e.getArgs());
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
            throw new ActionMessagesException(
                    "errors.crud_failed_to_delete_crud_table");
        }
    }

    protected void loadBoostDocumentRule() {

        final BoostDocumentRule boostDocumentRule = boostDocumentRuleService
                .getBoostDocumentRule(createKeyMap());
        if (boostDocumentRule == null) {
            // throw an exception
            throw new ActionMessagesException(
                    "errors.crud_could_not_find_crud_table",

                    new Object[] { boostDocumentRuleForm.id });

        }

        Beans.copy(boostDocumentRule, boostDocumentRuleForm)
                .excludes("searchParams", "mode")

                .execute();
    }

    protected BoostDocumentRule createBoostDocumentRule() {
        BoostDocumentRule boostDocumentRule;
        if (boostDocumentRuleForm.crudMode == CommonConstants.EDIT_MODE) {
            boostDocumentRule = boostDocumentRuleService
                    .getBoostDocumentRule(createKeyMap());
            if (boostDocumentRule == null) {
                // throw an exception
                throw new ActionMessagesException(
                        "errors.crud_could_not_find_crud_table",

                        new Object[] { boostDocumentRuleForm.id });

            }
        } else {
            boostDocumentRule = new BoostDocumentRule();
        }
        Beans.copy(boostDocumentRuleForm, boostDocumentRule)
                .excludes("searchParams", "mode")

                .execute();

        return boostDocumentRule;
    }

    protected Map<String, String> createKeyMap() {
        final Map<String, String> keys = new HashMap<String, String>();

        keys.put("id", boostDocumentRuleForm.id);

        return keys;
    }
}
