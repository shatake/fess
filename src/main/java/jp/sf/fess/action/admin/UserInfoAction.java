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

import javax.annotation.Resource;

import jp.sf.fess.crud.action.admin.BsUserInfoAction;
import jp.sf.fess.crud.util.SAStrutsUtil;
import jp.sf.fess.helper.SystemHelper;

import org.seasar.struts.annotation.Execute;

public class UserInfoAction extends BsUserInfoAction {

    private static final long serialVersionUID = 1L;

    @Resource
    protected SystemHelper systemHelper;

    public String getHelpLink() {
        return systemHelper.getHelpLink("userInfo");
    }

    @Execute(validator = false, input = "error.jsp")
    public String deleteall() {
        userInfoService.deleteAll(userInfoPager);
        SAStrutsUtil.addSessionMessage("success.user_info_delete_all");
        return displayList(true);
    }
}
