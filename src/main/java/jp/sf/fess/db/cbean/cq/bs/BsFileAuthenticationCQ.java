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

package jp.sf.fess.db.cbean.cq.bs;

import java.util.Map;

import jp.sf.fess.db.cbean.FileAuthenticationCB;
import jp.sf.fess.db.cbean.cq.FileAuthenticationCQ;
import jp.sf.fess.db.cbean.cq.FileCrawlingConfigCQ;
import jp.sf.fess.db.cbean.cq.ciq.FileAuthenticationCIQ;

import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.chelper.HpCalculator;
import org.seasar.dbflute.cbean.coption.ConditionOption;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;

/**
 * The base condition-query of FILE_AUTHENTICATION.
 * @author DBFlute(AutoGenerator)
 */
public class BsFileAuthenticationCQ extends AbstractBsFileAuthenticationCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected FileAuthenticationCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsFileAuthenticationCQ(final ConditionQuery referrerQuery,
            final SqlClause sqlClause, final String aliasName,
            final int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from FILE_AUTHENTICATION) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public FileAuthenticationCIQ inline() {
        if (_inlineQuery == null) {
            _inlineQuery = xcreateCIQ();
        }
        _inlineQuery.xsetOnClause(false);
        return _inlineQuery;
    }

    protected FileAuthenticationCIQ xcreateCIQ() {
        final FileAuthenticationCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected FileAuthenticationCIQ xnewCIQ() {
        return new FileAuthenticationCIQ(xgetReferrerQuery(), xgetSqlClause(),
                xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join FILE_AUTHENTICATION on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public FileAuthenticationCIQ on() {
        if (isBaseQuery()) {
            throw new IllegalConditionBeanOperationException(
                    "OnClause for local table is unavailable!");
        }
        final FileAuthenticationCIQ inlineQuery = inline();
        inlineQuery.xsetOnClause(true);
        return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _id;

    public ConditionValue getId() {
        if (_id == null) {
            _id = nCV();
        }
        return _id;
    }

    @Override
    protected ConditionValue getCValueId() {
        return getId();
    }

    /**
     * Add order-by as ascend. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Id_Asc() {
        regOBA("ID");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Id_Desc() {
        regOBD("ID");
        return this;
    }

    protected ConditionValue _hostname;

    public ConditionValue getHostname() {
        if (_hostname == null) {
            _hostname = nCV();
        }
        return _hostname;
    }

    @Override
    protected ConditionValue getCValueHostname() {
        return getHostname();
    }

    /**
     * Add order-by as ascend. <br />
     * HOSTNAME: {VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Hostname_Asc() {
        regOBA("HOSTNAME");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * HOSTNAME: {VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Hostname_Desc() {
        regOBD("HOSTNAME");
        return this;
    }

    protected ConditionValue _port;

    public ConditionValue getPort() {
        if (_port == null) {
            _port = nCV();
        }
        return _port;
    }

    @Override
    protected ConditionValue getCValuePort() {
        return getPort();
    }

    /**
     * Add order-by as ascend. <br />
     * PORT: {NotNull, INTEGER(10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Port_Asc() {
        regOBA("PORT");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * PORT: {NotNull, INTEGER(10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Port_Desc() {
        regOBD("PORT");
        return this;
    }

    protected ConditionValue _protocolScheme;

    public ConditionValue getProtocolScheme() {
        if (_protocolScheme == null) {
            _protocolScheme = nCV();
        }
        return _protocolScheme;
    }

    @Override
    protected ConditionValue getCValueProtocolScheme() {
        return getProtocolScheme();
    }

    /**
     * Add order-by as ascend. <br />
     * PROTOCOL_SCHEME: {VARCHAR(10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_ProtocolScheme_Asc() {
        regOBA("PROTOCOL_SCHEME");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * PROTOCOL_SCHEME: {VARCHAR(10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_ProtocolScheme_Desc() {
        regOBD("PROTOCOL_SCHEME");
        return this;
    }

    protected ConditionValue _username;

    public ConditionValue getUsername() {
        if (_username == null) {
            _username = nCV();
        }
        return _username;
    }

    @Override
    protected ConditionValue getCValueUsername() {
        return getUsername();
    }

    /**
     * Add order-by as ascend. <br />
     * USERNAME: {NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Username_Asc() {
        regOBA("USERNAME");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * USERNAME: {NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Username_Desc() {
        regOBD("USERNAME");
        return this;
    }

    protected ConditionValue _password;

    public ConditionValue getPassword() {
        if (_password == null) {
            _password = nCV();
        }
        return _password;
    }

    @Override
    protected ConditionValue getCValuePassword() {
        return getPassword();
    }

    /**
     * Add order-by as ascend. <br />
     * PASSWORD: {VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Password_Asc() {
        regOBA("PASSWORD");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * PASSWORD: {VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Password_Desc() {
        regOBD("PASSWORD");
        return this;
    }

    protected ConditionValue _parameters;

    public ConditionValue getParameters() {
        if (_parameters == null) {
            _parameters = nCV();
        }
        return _parameters;
    }

    @Override
    protected ConditionValue getCValueParameters() {
        return getParameters();
    }

    /**
     * Add order-by as ascend. <br />
     * PARAMETERS: {VARCHAR(1000)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Parameters_Asc() {
        regOBA("PARAMETERS");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * PARAMETERS: {VARCHAR(1000)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_Parameters_Desc() {
        regOBD("PARAMETERS");
        return this;
    }

    protected ConditionValue _fileCrawlingConfigId;

    public ConditionValue getFileCrawlingConfigId() {
        if (_fileCrawlingConfigId == null) {
            _fileCrawlingConfigId = nCV();
        }
        return _fileCrawlingConfigId;
    }

    @Override
    protected ConditionValue getCValueFileCrawlingConfigId() {
        return getFileCrawlingConfigId();
    }

    public Map<String, FileCrawlingConfigCQ> getFileCrawlingConfigId_InScopeRelation_FileCrawlingConfig() {
        return xgetSQueMap("fileCrawlingConfigId_InScopeRelation_FileCrawlingConfig");
    }

    @Override
    public String keepFileCrawlingConfigId_InScopeRelation_FileCrawlingConfig(
            final FileCrawlingConfigCQ sq) {
        return xkeepSQue(
                "fileCrawlingConfigId_InScopeRelation_FileCrawlingConfig", sq);
    }

    public Map<String, FileCrawlingConfigCQ> getFileCrawlingConfigId_NotInScopeRelation_FileCrawlingConfig() {
        return xgetSQueMap("fileCrawlingConfigId_NotInScopeRelation_FileCrawlingConfig");
    }

    @Override
    public String keepFileCrawlingConfigId_NotInScopeRelation_FileCrawlingConfig(
            final FileCrawlingConfigCQ sq) {
        return xkeepSQue(
                "fileCrawlingConfigId_NotInScopeRelation_FileCrawlingConfig",
                sq);
    }

    /**
     * Add order-by as ascend. <br />
     * FILE_CRAWLING_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to FILE_CRAWLING_CONFIG}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_FileCrawlingConfigId_Asc() {
        regOBA("FILE_CRAWLING_CONFIG_ID");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * FILE_CRAWLING_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to FILE_CRAWLING_CONFIG}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_FileCrawlingConfigId_Desc() {
        regOBD("FILE_CRAWLING_CONFIG_ID");
        return this;
    }

    protected ConditionValue _createdBy;

    public ConditionValue getCreatedBy() {
        if (_createdBy == null) {
            _createdBy = nCV();
        }
        return _createdBy;
    }

    @Override
    protected ConditionValue getCValueCreatedBy() {
        return getCreatedBy();
    }

    /**
     * Add order-by as ascend. <br />
     * CREATED_BY: {NotNull, VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_CreatedBy_Asc() {
        regOBA("CREATED_BY");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * CREATED_BY: {NotNull, VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_CreatedBy_Desc() {
        regOBD("CREATED_BY");
        return this;
    }

    protected ConditionValue _createdTime;

    public ConditionValue getCreatedTime() {
        if (_createdTime == null) {
            _createdTime = nCV();
        }
        return _createdTime;
    }

    @Override
    protected ConditionValue getCValueCreatedTime() {
        return getCreatedTime();
    }

    /**
     * Add order-by as ascend. <br />
     * CREATED_TIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_CreatedTime_Asc() {
        regOBA("CREATED_TIME");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * CREATED_TIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_CreatedTime_Desc() {
        regOBD("CREATED_TIME");
        return this;
    }

    protected ConditionValue _updatedBy;

    public ConditionValue getUpdatedBy() {
        if (_updatedBy == null) {
            _updatedBy = nCV();
        }
        return _updatedBy;
    }

    @Override
    protected ConditionValue getCValueUpdatedBy() {
        return getUpdatedBy();
    }

    /**
     * Add order-by as ascend. <br />
     * UPDATED_BY: {VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_UpdatedBy_Asc() {
        regOBA("UPDATED_BY");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * UPDATED_BY: {VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_UpdatedBy_Desc() {
        regOBD("UPDATED_BY");
        return this;
    }

    protected ConditionValue _updatedTime;

    public ConditionValue getUpdatedTime() {
        if (_updatedTime == null) {
            _updatedTime = nCV();
        }
        return _updatedTime;
    }

    @Override
    protected ConditionValue getCValueUpdatedTime() {
        return getUpdatedTime();
    }

    /**
     * Add order-by as ascend. <br />
     * UPDATED_TIME: {TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_UpdatedTime_Asc() {
        regOBA("UPDATED_TIME");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * UPDATED_TIME: {TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_UpdatedTime_Desc() {
        regOBD("UPDATED_TIME");
        return this;
    }

    protected ConditionValue _deletedBy;

    public ConditionValue getDeletedBy() {
        if (_deletedBy == null) {
            _deletedBy = nCV();
        }
        return _deletedBy;
    }

    @Override
    protected ConditionValue getCValueDeletedBy() {
        return getDeletedBy();
    }

    /**
     * Add order-by as ascend. <br />
     * DELETED_BY: {VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_DeletedBy_Asc() {
        regOBA("DELETED_BY");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * DELETED_BY: {VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_DeletedBy_Desc() {
        regOBD("DELETED_BY");
        return this;
    }

    protected ConditionValue _deletedTime;

    public ConditionValue getDeletedTime() {
        if (_deletedTime == null) {
            _deletedTime = nCV();
        }
        return _deletedTime;
    }

    @Override
    protected ConditionValue getCValueDeletedTime() {
        return getDeletedTime();
    }

    /**
     * Add order-by as ascend. <br />
     * DELETED_TIME: {TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_DeletedTime_Asc() {
        regOBA("DELETED_TIME");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * DELETED_TIME: {TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_DeletedTime_Desc() {
        regOBD("DELETED_TIME");
        return this;
    }

    protected ConditionValue _versionNo;

    public ConditionValue getVersionNo() {
        if (_versionNo == null) {
            _versionNo = nCV();
        }
        return _versionNo;
    }

    @Override
    protected ConditionValue getCValueVersionNo() {
        return getVersionNo();
    }

    /**
     * Add order-by as ascend. <br />
     * VERSION_NO: {NotNull, INTEGER(10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_VersionNo_Asc() {
        regOBA("VERSION_NO");
        return this;
    }

    /**
     * Add order-by as descend. <br />
     * VERSION_NO: {NotNull, INTEGER(10)}
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addOrderBy_VersionNo_Desc() {
        regOBD("VERSION_NO");
        return this;
    }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #DD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #DD4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #DD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addSpecifiedDerivedOrderBy_Asc(
            final String aliasName) {
        registerSpecifiedDerivedOrderBy_Asc(aliasName);
        return this;
    }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #DD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #DD4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #DD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsFileAuthenticationCQ addSpecifiedDerivedOrderBy_Desc(
            final String aliasName) {
        registerSpecifiedDerivedOrderBy_Desc(aliasName);
        return this;
    }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    @Override
    public void reflectRelationOnUnionQuery(final ConditionQuery bqs,
            final ConditionQuery uqs) {
        final FileAuthenticationCQ bq = (FileAuthenticationCQ) bqs;
        final FileAuthenticationCQ uq = (FileAuthenticationCQ) uqs;
        if (bq.hasConditionQueryFileCrawlingConfig()) {
            uq.queryFileCrawlingConfig().reflectRelationOnUnionQuery(
                    bq.queryFileCrawlingConfig(), uq.queryFileCrawlingConfig());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * FILE_CRAWLING_CONFIG by my FILE_CRAWLING_CONFIG_ID, named 'fileCrawlingConfig'.
     * @return The instance of condition-query. (NotNull)
     */
    public FileCrawlingConfigCQ queryFileCrawlingConfig() {
        return getConditionQueryFileCrawlingConfig();
    }

    public FileCrawlingConfigCQ getConditionQueryFileCrawlingConfig() {
        final String prop = "fileCrawlingConfig";
        if (!xhasQueRlMap(prop)) {
            xregQueRl(prop, xcreateQueryFileCrawlingConfig());
            xsetupOuterJoinFileCrawlingConfig();
        }
        return xgetQueRlMap(prop);
    }

    protected FileCrawlingConfigCQ xcreateQueryFileCrawlingConfig() {
        final String nrp = xresolveNRP("FILE_AUTHENTICATION",
                "fileCrawlingConfig");
        final String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new FileCrawlingConfigCQ(this, xgetSqlClause(), jan,
                xgetNNLvl()), _baseCB, "fileCrawlingConfig", nrp);
    }

    protected void xsetupOuterJoinFileCrawlingConfig() {
        xregOutJo("fileCrawlingConfig");
    }

    public boolean hasConditionQueryFileCrawlingConfig() {
        return xhasQueRlMap("fileCrawlingConfig");
    }

    @Override
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(
            final String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, FileAuthenticationCQ> getScalarCondition() {
        return xgetSQueMap("scalarCondition");
    }

    @Override
    public String keepScalarCondition(final FileAuthenticationCQ sq) {
        return xkeepSQue("scalarCondition", sq);
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, FileAuthenticationCQ> getSpecifyMyselfDerived() {
        return xgetSQueMap("specifyMyselfDerived");
    }

    @Override
    public String keepSpecifyMyselfDerived(final FileAuthenticationCQ sq) {
        return xkeepSQue("specifyMyselfDerived", sq);
    }

    public Map<String, FileAuthenticationCQ> getQueryMyselfDerived() {
        return xgetSQueMap("queryMyselfDerived");
    }

    @Override
    public String keepQueryMyselfDerived(final FileAuthenticationCQ sq) {
        return xkeepSQue("queryMyselfDerived", sq);
    }

    public Map<String, Object> getQueryMyselfDerivedParameter() {
        return xgetSQuePmMap("queryMyselfDerived");
    }

    @Override
    public String keepQueryMyselfDerivedParameter(final Object pm) {
        return xkeepSQuePm("queryMyselfDerived", pm);
    }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, FileAuthenticationCQ> _myselfExistsMap;

    public Map<String, FileAuthenticationCQ> getMyselfExists() {
        return xgetSQueMap("myselfExists");
    }

    @Override
    public String keepMyselfExists(final FileAuthenticationCQ sq) {
        return xkeepSQue("myselfExists", sq);
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, FileAuthenticationCQ> getMyselfInScope() {
        return xgetSQueMap("myselfInScope");
    }

    @Override
    public String keepMyselfInScope(final FileAuthenticationCQ sq) {
        return xkeepSQue("myselfInScope", sq);
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() {
        return FileAuthenticationCB.class.getName();
    }

    protected String xCQ() {
        return FileAuthenticationCQ.class.getName();
    }

    protected String xCHp() {
        return HpCalculator.class.getName();
    }

    protected String xCOp() {
        return ConditionOption.class.getName();
    }

    protected String xMap() {
        return Map.class.getName();
    }
}
