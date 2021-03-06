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

package jp.sf.fess.db.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import jp.sf.fess.db.allcommon.CDef;
import jp.sf.fess.db.allcommon.DBCurrent;
import jp.sf.fess.db.allcommon.DBFluteConfig;
import jp.sf.fess.db.exentity.PathMapping;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.ColumnInfo;
import org.seasar.dbflute.dbmeta.info.UniqueInfo;
import org.seasar.dbflute.dbmeta.name.TableSqlName;

/**
 * The DB meta of PATH_MAPPING. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PathMappingDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PathMappingDbm _instance = new PathMappingDbm();

    private PathMappingDbm() {
    }

    public static PathMappingDbm getInstance() {
        return _instance;
    }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    @Override
    public DBDef getCurrentDBDef() {
        return DBCurrent.getInstance().currentDBDef();
    }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgId(), "id");
        setupEpg(_epgMap, new EpgRegex(), "regex");
        setupEpg(_epgMap, new EpgReplacement(), "replacement");
        setupEpg(_epgMap, new EpgProcessType(), "processType");
        setupEpg(_epgMap, new EpgSortOrder(), "sortOrder");
        setupEpg(_epgMap, new EpgCreatedBy(), "createdBy");
        setupEpg(_epgMap, new EpgCreatedTime(), "createdTime");
        setupEpg(_epgMap, new EpgUpdatedBy(), "updatedBy");
        setupEpg(_epgMap, new EpgUpdatedTime(), "updatedTime");
        setupEpg(_epgMap, new EpgDeletedBy(), "deletedBy");
        setupEpg(_epgMap, new EpgDeletedTime(), "deletedTime");
        setupEpg(_epgMap, new EpgVersionNo(), "versionNo");
    }

    public static class EpgId implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getId();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setId(ctl(vl));
        }
    }

    public static class EpgRegex implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getRegex();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setRegex((String) vl);
        }
    }

    public static class EpgReplacement implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getReplacement();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setReplacement((String) vl);
        }
    }

    public static class EpgProcessType implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getProcessType();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setProcessType((String) vl);
        }
    }

    public static class EpgSortOrder implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getSortOrder();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setSortOrder(cti(vl));
        }
    }

    public static class EpgCreatedBy implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getCreatedBy();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setCreatedBy((String) vl);
        }
    }

    public static class EpgCreatedTime implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getCreatedTime();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setCreatedTime((java.sql.Timestamp) vl);
        }
    }

    public static class EpgUpdatedBy implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getUpdatedBy();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setUpdatedBy((String) vl);
        }
    }

    public static class EpgUpdatedTime implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getUpdatedTime();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setUpdatedTime((java.sql.Timestamp) vl);
        }
    }

    public static class EpgDeletedBy implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getDeletedBy();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setDeletedBy((String) vl);
        }
    }

    public static class EpgDeletedTime implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getDeletedTime();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setDeletedTime((java.sql.Timestamp) vl);
        }
    }

    public static class EpgVersionNo implements PropertyGateway {
        @Override
        public Object read(final Entity et) {
            return ((PathMapping) et).getVersionNo();
        }

        @Override
        public void write(final Entity et, final Object vl) {
            ((PathMapping) et).setVersionNo(cti(vl));
        }
    }

    @Override
    public PropertyGateway findPropertyGateway(final String prop) {
        return doFindEpg(_epgMap, prop);
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "PATH_MAPPING";

    protected final String _tablePropertyName = "pathMapping";

    protected final TableSqlName _tableSqlName = new TableSqlName(
            "PATH_MAPPING", _tableDbName);
    {
        _tableSqlName.xacceptFilter(DBFluteConfig.getInstance()
                .getTableSqlNameFilter());
    }

    @Override
    public String getTableDbName() {
        return _tableDbName;
    }

    @Override
    public String getTablePropertyName() {
        return _tablePropertyName;
    }

    @Override
    public TableSqlName getTableSqlName() {
        return _tableSqlName;
    }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci(
            "ID",
            "ID",
            null,
            null,
            Long.class,
            "id",
            null,
            true,
            true,
            true,
            "BIGINT",
            19,
            0,
            "NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_517DE2D9_E34C_4896_8AED_9F4601BF195C",
            false, null, null, null, null, null);

    protected final ColumnInfo _columnRegex = cci("REGEX", "REGEX", null, null,
            String.class, "regex", null, false, false, true, "VARCHAR", 1000,
            0, null, false, null, null, null, null, null);

    protected final ColumnInfo _columnReplacement = cci("REPLACEMENT",
            "REPLACEMENT", null, null, String.class, "replacement", null,
            false, false, true, "VARCHAR", 1000, 0, null, false, null, null,
            null, null, null);

    protected final ColumnInfo _columnProcessType = cci("PROCESS_TYPE",
            "PROCESS_TYPE", null, null, String.class, "processType", null,
            false, false, true, "VARCHAR", 1, 0, null, false, null, null, null,
            null, CDef.DefMeta.ProcessType);

    protected final ColumnInfo _columnSortOrder = cci("SORT_ORDER",
            "SORT_ORDER", null, null, Integer.class, "sortOrder", null, false,
            false, true, "INTEGER", 10, 0, null, false, null, null, null, null,
            null);

    protected final ColumnInfo _columnCreatedBy = cci("CREATED_BY",
            "CREATED_BY", null, null, String.class, "createdBy", null, false,
            false, true, "VARCHAR", 255, 0, null, false, null, null, null,
            null, null);

    protected final ColumnInfo _columnCreatedTime = cci("CREATED_TIME",
            "CREATED_TIME", null, null, java.sql.Timestamp.class,
            "createdTime", null, false, false, true, "TIMESTAMP", 23, 10, null,
            false, null, null, null, null, null);

    protected final ColumnInfo _columnUpdatedBy = cci("UPDATED_BY",
            "UPDATED_BY", null, null, String.class, "updatedBy", null, false,
            false, false, "VARCHAR", 255, 0, null, false, null, null, null,
            null, null);

    protected final ColumnInfo _columnUpdatedTime = cci("UPDATED_TIME",
            "UPDATED_TIME", null, null, java.sql.Timestamp.class,
            "updatedTime", null, false, false, false, "TIMESTAMP", 23, 10,
            null, false, null, null, null, null, null);

    protected final ColumnInfo _columnDeletedBy = cci("DELETED_BY",
            "DELETED_BY", null, null, String.class, "deletedBy", null, false,
            false, false, "VARCHAR", 255, 0, null, false, null, null, null,
            null, null);

    protected final ColumnInfo _columnDeletedTime = cci("DELETED_TIME",
            "DELETED_TIME", null, null, java.sql.Timestamp.class,
            "deletedTime", null, false, false, false, "TIMESTAMP", 23, 10,
            null, false, null, null, null, null, null);

    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO",
            "VERSION_NO", null, null, Integer.class, "versionNo", null, false,
            false, true, "INTEGER", 10, 0, null, false,
            OptimisticLockType.VERSION_NO, null, null, null, null);

    /**
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnId() {
        return _columnId;
    }

    /**
     * REGEX: {NotNull, VARCHAR(1000)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegex() {
        return _columnRegex;
    }

    /**
     * REPLACEMENT: {NotNull, VARCHAR(1000)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnReplacement() {
        return _columnReplacement;
    }

    /**
     * PROCESS_TYPE: {NotNull, VARCHAR(1), classification=ProcessType}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnProcessType() {
        return _columnProcessType;
    }

    /**
     * SORT_ORDER: {NotNull, INTEGER(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnSortOrder() {
        return _columnSortOrder;
    }

    /**
     * CREATED_BY: {NotNull, VARCHAR(255)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCreatedBy() {
        return _columnCreatedBy;
    }

    /**
     * CREATED_TIME: {NotNull, TIMESTAMP(23, 10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCreatedTime() {
        return _columnCreatedTime;
    }

    /**
     * UPDATED_BY: {VARCHAR(255)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdatedBy() {
        return _columnUpdatedBy;
    }

    /**
     * UPDATED_TIME: {TIMESTAMP(23, 10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdatedTime() {
        return _columnUpdatedTime;
    }

    /**
     * DELETED_BY: {VARCHAR(255)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDeletedBy() {
        return _columnDeletedBy;
    }

    /**
     * DELETED_TIME: {TIMESTAMP(23, 10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDeletedTime() {
        return _columnDeletedTime;
    }

    /**
     * VERSION_NO: {NotNull, INTEGER(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVersionNo() {
        return _columnVersionNo;
    }

    @Override
    protected List<ColumnInfo> ccil() {
        final List<ColumnInfo> ls = newArrayList();
        ls.add(columnId());
        ls.add(columnRegex());
        ls.add(columnReplacement());
        ls.add(columnProcessType());
        ls.add(columnSortOrder());
        ls.add(columnCreatedBy());
        ls.add(columnCreatedTime());
        ls.add(columnUpdatedBy());
        ls.add(columnUpdatedTime());
        ls.add(columnDeletedBy());
        ls.add(columnDeletedTime());
        ls.add(columnVersionNo());
        return ls;
    }

    {
        initializeInformationResource();
    }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    @Override
    protected UniqueInfo cpui() {
        return hpcpui(columnId());
    }

    @Override
    public boolean hasPrimaryKey() {
        return true;
    }

    @Override
    public boolean hasCompoundPrimaryKey() {
        return false;
    }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    @Override
    public boolean hasIdentity() {
        return true;
    }

    @Override
    public boolean hasVersionNo() {
        return true;
    }

    @Override
    public ColumnInfo getVersionNoColumnInfo() {
        return _columnVersionNo;
    }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    @Override
    public String getEntityTypeName() {
        return "jp.sf.fess.db.exentity.PathMapping";
    }

    @Override
    public String getConditionBeanTypeName() {
        return "jp.sf.fess.db.cbean.PathMappingCB";
    }

    @Override
    public String getBehaviorTypeName() {
        return "jp.sf.fess.db.exbhv.PathMappingBhv";
    }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    @Override
    public Class<PathMapping> getEntityType() {
        return PathMapping.class;
    }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    @Override
    public PathMapping newEntity() {
        return new PathMapping();
    }

    public PathMapping newMyEntity() {
        return new PathMapping();
    }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    @Override
    public void acceptPrimaryKeyMap(final Entity et,
            final Map<String, ? extends Object> mp) {
        doAcceptPrimaryKeyMap((PathMapping) et, mp);
    }

    @Override
    public void acceptAllColumnMap(final Entity et,
            final Map<String, ? extends Object> mp) {
        doAcceptAllColumnMap((PathMapping) et, mp);
    }

    @Override
    public Map<String, Object> extractPrimaryKeyMap(final Entity et) {
        return doExtractPrimaryKeyMap(et);
    }

    @Override
    public Map<String, Object> extractAllColumnMap(final Entity et) {
        return doExtractAllColumnMap(et);
    }
}
