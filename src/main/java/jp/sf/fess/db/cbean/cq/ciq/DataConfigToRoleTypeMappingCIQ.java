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

package jp.sf.fess.db.cbean.cq.ciq;

import java.util.Map;

import jp.sf.fess.db.cbean.DataConfigToRoleTypeMappingCB;
import jp.sf.fess.db.cbean.cq.DataConfigToRoleTypeMappingCQ;
import jp.sf.fess.db.cbean.cq.DataCrawlingConfigCQ;
import jp.sf.fess.db.cbean.cq.RoleTypeCQ;
import jp.sf.fess.db.cbean.cq.bs.AbstractBsDataConfigToRoleTypeMappingCQ;
import jp.sf.fess.db.cbean.cq.bs.BsDataConfigToRoleTypeMappingCQ;

import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.ckey.ConditionKey;
import org.seasar.dbflute.cbean.coption.ConditionOption;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;

/**
 * The condition-query for in-line of DATA_CONFIG_TO_ROLE_TYPE_MAPPING.
 * @author DBFlute(AutoGenerator)
 */
public class DataConfigToRoleTypeMappingCIQ extends
        AbstractBsDataConfigToRoleTypeMappingCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsDataConfigToRoleTypeMappingCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public DataConfigToRoleTypeMappingCIQ(final ConditionQuery referrerQuery,
            final SqlClause sqlClause, final String aliasName,
            final int nestLevel, final BsDataConfigToRoleTypeMappingCQ myCQ) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
        _myCQ = myCQ;
        _foreignPropertyName = _myCQ.xgetForeignPropertyName(); // accept foreign property name
        _relationPath = _myCQ.xgetRelationPath(); // accept relation path
        _inline = true;
    }

    // ===================================================================================
    //                                                             Override about Register
    //                                                             =======================
    @Override
    protected void reflectRelationOnUnionQuery(final ConditionQuery bq,
            final ConditionQuery uq) {
        throw new IllegalConditionBeanOperationException(
                "InlineView cannot use Union: " + bq + " : " + uq);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(
            final ConditionKey k, final Object v, final ConditionValue cv,
            final String col) {
        regIQ(k, v, cv, col);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(
            final ConditionKey k, final Object v, final ConditionValue cv,
            final String col, final ConditionOption op) {
        regIQ(k, v, cv, col, op);
    }

    @Override
    protected void registerWhereClause(final String wc) {
        registerInlineWhereClause(wc);
    }

    @Override
    protected boolean isInScopeRelationSuppressLocalAliasName() {
        if (_onClause) {
            throw new IllegalConditionBeanOperationException(
                    "InScopeRelation on OnClause is unsupported.");
        }
        return true;
    }

    // ===================================================================================
    //                                                                Override about Query
    //                                                                ====================
    @Override
    protected ConditionValue getCValueId() {
        return _myCQ.getId();
    }

    @Override
    protected ConditionValue getCValueDataConfigId() {
        return _myCQ.getDataConfigId();
    }

    @Override
    public String keepDataConfigId_InScopeRelation_DataCrawlingConfig(
            final DataCrawlingConfigCQ sq) {
        return _myCQ.keepDataConfigId_InScopeRelation_DataCrawlingConfig(sq);
    }

    @Override
    public String keepDataConfigId_NotInScopeRelation_DataCrawlingConfig(
            final DataCrawlingConfigCQ sq) {
        return _myCQ.keepDataConfigId_NotInScopeRelation_DataCrawlingConfig(sq);
    }

    @Override
    protected ConditionValue getCValueRoleTypeId() {
        return _myCQ.getRoleTypeId();
    }

    @Override
    public String keepRoleTypeId_InScopeRelation_RoleType(final RoleTypeCQ sq) {
        return _myCQ.keepRoleTypeId_InScopeRelation_RoleType(sq);
    }

    @Override
    public String keepRoleTypeId_NotInScopeRelation_RoleType(final RoleTypeCQ sq) {
        return _myCQ.keepRoleTypeId_NotInScopeRelation_RoleType(sq);
    }

    @Override
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(
            final String pp) {
        return null;
    }

    @Override
    public String keepScalarCondition(final DataConfigToRoleTypeMappingCQ sq) {
        throwIICBOE("ScalarCondition");
        return null;
    }

    @Override
    public String keepSpecifyMyselfDerived(
            final DataConfigToRoleTypeMappingCQ sq) {
        throwIICBOE("(Specify)MyselfDerived");
        return null;
    }

    @Override
    public String keepQueryMyselfDerived(final DataConfigToRoleTypeMappingCQ sq) {
        throwIICBOE("(Query)MyselfDerived");
        return null;
    }

    @Override
    public String keepQueryMyselfDerivedParameter(final Object vl) {
        throwIICBOE("(Query)MyselfDerived");
        return null;
    }

    @Override
    public String keepMyselfExists(final DataConfigToRoleTypeMappingCQ sq) {
        throwIICBOE("MyselfExists");
        return null;
    }

    @Override
    public String keepMyselfInScope(final DataConfigToRoleTypeMappingCQ sq) {
        throwIICBOE("MyselfInScope");
        return null;
    }

    protected void throwIICBOE(final String name) {
        throw new IllegalConditionBeanOperationException(name
                + " at InlineView is unsupported.");
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() {
        return DataConfigToRoleTypeMappingCB.class.getName();
    }

    protected String xinCQ() {
        return DataConfigToRoleTypeMappingCQ.class.getName();
    }
}
