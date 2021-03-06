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

import jp.sf.fess.db.cbean.FileCrawlingConfigCB;
import jp.sf.fess.db.cbean.cq.FileAuthenticationCQ;
import jp.sf.fess.db.cbean.cq.FileConfigToLabelTypeMappingCQ;
import jp.sf.fess.db.cbean.cq.FileConfigToRoleTypeMappingCQ;
import jp.sf.fess.db.cbean.cq.FileCrawlingConfigCQ;
import jp.sf.fess.db.cbean.cq.bs.AbstractBsFileCrawlingConfigCQ;
import jp.sf.fess.db.cbean.cq.bs.BsFileCrawlingConfigCQ;

import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.ckey.ConditionKey;
import org.seasar.dbflute.cbean.coption.ConditionOption;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;

/**
 * The condition-query for in-line of FILE_CRAWLING_CONFIG.
 * @author DBFlute(AutoGenerator)
 */
public class FileCrawlingConfigCIQ extends AbstractBsFileCrawlingConfigCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsFileCrawlingConfigCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public FileCrawlingConfigCIQ(final ConditionQuery referrerQuery,
            final SqlClause sqlClause, final String aliasName,
            final int nestLevel, final BsFileCrawlingConfigCQ myCQ) {
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
    public String keepId_ExistsReferrer_FileAuthenticationList(
            final FileAuthenticationCQ sq) {
        throwIICBOE("ExistsReferrer");
        return null;
    }

    @Override
    public String keepId_ExistsReferrer_FileConfigToLabelTypeMappingList(
            final FileConfigToLabelTypeMappingCQ sq) {
        throwIICBOE("ExistsReferrer");
        return null;
    }

    @Override
    public String keepId_ExistsReferrer_FileConfigToRoleTypeMappingList(
            final FileConfigToRoleTypeMappingCQ sq) {
        throwIICBOE("ExistsReferrer");
        return null;
    }

    @Override
    public String keepId_NotExistsReferrer_FileAuthenticationList(
            final FileAuthenticationCQ sq) {
        throwIICBOE("NotExistsReferrer");
        return null;
    }

    @Override
    public String keepId_NotExistsReferrer_FileConfigToLabelTypeMappingList(
            final FileConfigToLabelTypeMappingCQ sq) {
        throwIICBOE("NotExistsReferrer");
        return null;
    }

    @Override
    public String keepId_NotExistsReferrer_FileConfigToRoleTypeMappingList(
            final FileConfigToRoleTypeMappingCQ sq) {
        throwIICBOE("NotExistsReferrer");
        return null;
    }

    @Override
    public String keepId_InScopeRelation_FileAuthenticationList(
            final FileAuthenticationCQ sq) {
        return _myCQ.keepId_InScopeRelation_FileAuthenticationList(sq);
    }

    @Override
    public String keepId_InScopeRelation_FileConfigToLabelTypeMappingList(
            final FileConfigToLabelTypeMappingCQ sq) {
        return _myCQ
                .keepId_InScopeRelation_FileConfigToLabelTypeMappingList(sq);
    }

    @Override
    public String keepId_InScopeRelation_FileConfigToRoleTypeMappingList(
            final FileConfigToRoleTypeMappingCQ sq) {
        return _myCQ.keepId_InScopeRelation_FileConfigToRoleTypeMappingList(sq);
    }

    @Override
    public String keepId_NotInScopeRelation_FileAuthenticationList(
            final FileAuthenticationCQ sq) {
        return _myCQ.keepId_NotInScopeRelation_FileAuthenticationList(sq);
    }

    @Override
    public String keepId_NotInScopeRelation_FileConfigToLabelTypeMappingList(
            final FileConfigToLabelTypeMappingCQ sq) {
        return _myCQ
                .keepId_NotInScopeRelation_FileConfigToLabelTypeMappingList(sq);
    }

    @Override
    public String keepId_NotInScopeRelation_FileConfigToRoleTypeMappingList(
            final FileConfigToRoleTypeMappingCQ sq) {
        return _myCQ
                .keepId_NotInScopeRelation_FileConfigToRoleTypeMappingList(sq);
    }

    @Override
    public String keepId_SpecifyDerivedReferrer_FileAuthenticationList(
            final FileAuthenticationCQ sq) {
        throwIICBOE("(Specify)DerivedReferrer");
        return null;
    }

    @Override
    public String keepId_SpecifyDerivedReferrer_FileConfigToLabelTypeMappingList(
            final FileConfigToLabelTypeMappingCQ sq) {
        throwIICBOE("(Specify)DerivedReferrer");
        return null;
    }

    @Override
    public String keepId_SpecifyDerivedReferrer_FileConfigToRoleTypeMappingList(
            final FileConfigToRoleTypeMappingCQ sq) {
        throwIICBOE("(Specify)DerivedReferrer");
        return null;
    }

    @Override
    public String keepId_QueryDerivedReferrer_FileAuthenticationList(
            final FileAuthenticationCQ sq) {
        throwIICBOE("(Query)DerivedReferrer");
        return null;
    }

    @Override
    public String keepId_QueryDerivedReferrer_FileAuthenticationListParameter(
            final Object vl) {
        throwIICBOE("(Query)DerivedReferrer");
        return null;
    }

    @Override
    public String keepId_QueryDerivedReferrer_FileConfigToLabelTypeMappingList(
            final FileConfigToLabelTypeMappingCQ sq) {
        throwIICBOE("(Query)DerivedReferrer");
        return null;
    }

    @Override
    public String keepId_QueryDerivedReferrer_FileConfigToLabelTypeMappingListParameter(
            final Object vl) {
        throwIICBOE("(Query)DerivedReferrer");
        return null;
    }

    @Override
    public String keepId_QueryDerivedReferrer_FileConfigToRoleTypeMappingList(
            final FileConfigToRoleTypeMappingCQ sq) {
        throwIICBOE("(Query)DerivedReferrer");
        return null;
    }

    @Override
    public String keepId_QueryDerivedReferrer_FileConfigToRoleTypeMappingListParameter(
            final Object vl) {
        throwIICBOE("(Query)DerivedReferrer");
        return null;
    }

    @Override
    protected ConditionValue getCValueName() {
        return _myCQ.getName();
    }

    @Override
    protected ConditionValue getCValuePaths() {
        return _myCQ.getPaths();
    }

    @Override
    protected ConditionValue getCValueIncludedPaths() {
        return _myCQ.getIncludedPaths();
    }

    @Override
    protected ConditionValue getCValueExcludedPaths() {
        return _myCQ.getExcludedPaths();
    }

    @Override
    protected ConditionValue getCValueIncludedDocPaths() {
        return _myCQ.getIncludedDocPaths();
    }

    @Override
    protected ConditionValue getCValueExcludedDocPaths() {
        return _myCQ.getExcludedDocPaths();
    }

    @Override
    protected ConditionValue getCValueConfigParameter() {
        return _myCQ.getConfigParameter();
    }

    @Override
    protected ConditionValue getCValueDepth() {
        return _myCQ.getDepth();
    }

    @Override
    protected ConditionValue getCValueMaxAccessCount() {
        return _myCQ.getMaxAccessCount();
    }

    @Override
    protected ConditionValue getCValueNumOfThread() {
        return _myCQ.getNumOfThread();
    }

    @Override
    protected ConditionValue getCValueIntervalTime() {
        return _myCQ.getIntervalTime();
    }

    @Override
    protected ConditionValue getCValueBoost() {
        return _myCQ.getBoost();
    }

    @Override
    protected ConditionValue getCValueAvailable() {
        return _myCQ.getAvailable();
    }

    @Override
    protected ConditionValue getCValueSortOrder() {
        return _myCQ.getSortOrder();
    }

    @Override
    protected ConditionValue getCValueCreatedBy() {
        return _myCQ.getCreatedBy();
    }

    @Override
    protected ConditionValue getCValueCreatedTime() {
        return _myCQ.getCreatedTime();
    }

    @Override
    protected ConditionValue getCValueUpdatedBy() {
        return _myCQ.getUpdatedBy();
    }

    @Override
    protected ConditionValue getCValueUpdatedTime() {
        return _myCQ.getUpdatedTime();
    }

    @Override
    protected ConditionValue getCValueDeletedBy() {
        return _myCQ.getDeletedBy();
    }

    @Override
    protected ConditionValue getCValueDeletedTime() {
        return _myCQ.getDeletedTime();
    }

    @Override
    protected ConditionValue getCValueVersionNo() {
        return _myCQ.getVersionNo();
    }

    @Override
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(
            final String pp) {
        return null;
    }

    @Override
    public String keepScalarCondition(final FileCrawlingConfigCQ sq) {
        throwIICBOE("ScalarCondition");
        return null;
    }

    @Override
    public String keepSpecifyMyselfDerived(final FileCrawlingConfigCQ sq) {
        throwIICBOE("(Specify)MyselfDerived");
        return null;
    }

    @Override
    public String keepQueryMyselfDerived(final FileCrawlingConfigCQ sq) {
        throwIICBOE("(Query)MyselfDerived");
        return null;
    }

    @Override
    public String keepQueryMyselfDerivedParameter(final Object vl) {
        throwIICBOE("(Query)MyselfDerived");
        return null;
    }

    @Override
    public String keepMyselfExists(final FileCrawlingConfigCQ sq) {
        throwIICBOE("MyselfExists");
        return null;
    }

    @Override
    public String keepMyselfInScope(final FileCrawlingConfigCQ sq) {
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
        return FileCrawlingConfigCB.class.getName();
    }

    protected String xinCQ() {
        return FileCrawlingConfigCQ.class.getName();
    }
}
