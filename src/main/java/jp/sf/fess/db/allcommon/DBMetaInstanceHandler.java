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

package jp.sf.fess.db.allcommon;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import org.seasar.dbflute.exception.DBMetaNotFoundException;
import org.seasar.dbflute.helper.StringKeyMap;
import org.seasar.dbflute.util.DfAssertUtil;

/**
 * The handler of the instance of DB meta.
 * @author DBFlute(AutoGenerator)
 */
public class DBMetaInstanceHandler implements DBMetaProvider {

    // ===================================================================================
    //                                                                        Resource Map
    //                                                                        ============
    /** The map of DB meta instance by key 'table DB-name'. (NotNull, LazyLoaded) */
    protected static final Map<String, DBMeta> _tableDbNameInstanceMap = newHashMap();

    /** The map of DB meta instance by key 'entity type'. (NotNull, LazyLoaded) */
    protected static final Map<Class<?>, DBMeta> _entityTypeInstanceMap = newHashMap();

    /** The map of table DB name and DB meta class name. (NotNull) */
    protected static final Map<String, String> _tableDbNameClassNameMap;
    static {
        final Map<String, String> tmpMap = newHashMap();
        tmpMap.put("BOOST_DOCUMENT_RULE",
                "jp.sf.fess.db.bsentity.dbmeta.BoostDocumentRuleDbm");
        tmpMap.put("CLICK_LOG", "jp.sf.fess.db.bsentity.dbmeta.ClickLogDbm");
        tmpMap.put("CRAWLING_SESSION",
                "jp.sf.fess.db.bsentity.dbmeta.CrawlingSessionDbm");
        tmpMap.put("CRAWLING_SESSION_INFO",
                "jp.sf.fess.db.bsentity.dbmeta.CrawlingSessionInfoDbm");
        tmpMap.put("DATA_CONFIG_TO_LABEL_TYPE_MAPPING",
                "jp.sf.fess.db.bsentity.dbmeta.DataConfigToLabelTypeMappingDbm");
        tmpMap.put("DATA_CONFIG_TO_ROLE_TYPE_MAPPING",
                "jp.sf.fess.db.bsentity.dbmeta.DataConfigToRoleTypeMappingDbm");
        tmpMap.put("DATA_CRAWLING_CONFIG",
                "jp.sf.fess.db.bsentity.dbmeta.DataCrawlingConfigDbm");
        tmpMap.put("FAILURE_URL", "jp.sf.fess.db.bsentity.dbmeta.FailureUrlDbm");
        tmpMap.put("FAVORITE_LOG",
                "jp.sf.fess.db.bsentity.dbmeta.FavoriteLogDbm");
        tmpMap.put("FILE_AUTHENTICATION",
                "jp.sf.fess.db.bsentity.dbmeta.FileAuthenticationDbm");
        tmpMap.put("FILE_CONFIG_TO_LABEL_TYPE_MAPPING",
                "jp.sf.fess.db.bsentity.dbmeta.FileConfigToLabelTypeMappingDbm");
        tmpMap.put("FILE_CONFIG_TO_ROLE_TYPE_MAPPING",
                "jp.sf.fess.db.bsentity.dbmeta.FileConfigToRoleTypeMappingDbm");
        tmpMap.put("FILE_CRAWLING_CONFIG",
                "jp.sf.fess.db.bsentity.dbmeta.FileCrawlingConfigDbm");
        tmpMap.put("JOB_LOG", "jp.sf.fess.db.bsentity.dbmeta.JobLogDbm");
        tmpMap.put("KEY_MATCH", "jp.sf.fess.db.bsentity.dbmeta.KeyMatchDbm");
        tmpMap.put("LABEL_TYPE", "jp.sf.fess.db.bsentity.dbmeta.LabelTypeDbm");
        tmpMap.put("LABEL_TYPE_TO_ROLE_TYPE_MAPPING",
                "jp.sf.fess.db.bsentity.dbmeta.LabelTypeToRoleTypeMappingDbm");
        tmpMap.put("OVERLAPPING_HOST",
                "jp.sf.fess.db.bsentity.dbmeta.OverlappingHostDbm");
        tmpMap.put("PATH_MAPPING",
                "jp.sf.fess.db.bsentity.dbmeta.PathMappingDbm");
        tmpMap.put("REQUEST_HEADER",
                "jp.sf.fess.db.bsentity.dbmeta.RequestHeaderDbm");
        tmpMap.put("ROLE_TYPE", "jp.sf.fess.db.bsentity.dbmeta.RoleTypeDbm");
        tmpMap.put("SCHEDULED_JOB",
                "jp.sf.fess.db.bsentity.dbmeta.ScheduledJobDbm");
        tmpMap.put("SEARCH_FIELD_LOG",
                "jp.sf.fess.db.bsentity.dbmeta.SearchFieldLogDbm");
        tmpMap.put("SEARCH_LOG", "jp.sf.fess.db.bsentity.dbmeta.SearchLogDbm");
        tmpMap.put("SUGGEST_BAD_WORD",
                "jp.sf.fess.db.bsentity.dbmeta.SuggestBadWordDbm");
        tmpMap.put("SUGGEST_ELEVATE_WORD",
                "jp.sf.fess.db.bsentity.dbmeta.SuggestElevateWordDbm");
        tmpMap.put("USER_INFO", "jp.sf.fess.db.bsentity.dbmeta.UserInfoDbm");
        tmpMap.put("WEB_AUTHENTICATION",
                "jp.sf.fess.db.bsentity.dbmeta.WebAuthenticationDbm");
        tmpMap.put("WEB_CONFIG_TO_LABEL_TYPE_MAPPING",
                "jp.sf.fess.db.bsentity.dbmeta.WebConfigToLabelTypeMappingDbm");
        tmpMap.put("WEB_CONFIG_TO_ROLE_TYPE_MAPPING",
                "jp.sf.fess.db.bsentity.dbmeta.WebConfigToRoleTypeMappingDbm");
        tmpMap.put("WEB_CRAWLING_CONFIG",
                "jp.sf.fess.db.bsentity.dbmeta.WebCrawlingConfigDbm");
        _tableDbNameClassNameMap = Collections.unmodifiableMap(tmpMap);
    }

    /** The flexible map of table DB name for conversion in finding process. (NotNull) */
    protected static final Map<String, String> _tableDbNameFlexibleMap = StringKeyMap
            .createAsFlexible();
    static {
        for (final String tableDbName : _tableDbNameClassNameMap.keySet()) {
            _tableDbNameFlexibleMap.put(tableDbName, tableDbName);
        }
    }

    /**
     * Get the unmodifiable map of DB meta.
     * @return The unmodifiable map that contains all instances of DB meta. (NotNull, NotEmpty)
     */
    public static Map<String, DBMeta> getUnmodifiableDBMetaMap() {
        initializeDBMetaMap();
        synchronized (_tableDbNameInstanceMap) {
            return Collections.unmodifiableMap(_tableDbNameInstanceMap);
        }
    }

    /**
     * Initialize the map of DB meta.
     */
    protected static void initializeDBMetaMap() {
        if (isInitialized()) {
            return;
        }
        synchronized (_tableDbNameInstanceMap) {
            for (final String tableDbName : _tableDbNameClassNameMap.keySet()) {
                findDBMeta(tableDbName); // initialize
            }
            if (!isInitialized()) {
                final String msg = "Failed to initialize tableDbNameInstanceMap: "
                        + _tableDbNameInstanceMap;
                throw new IllegalStateException(msg);
            }
        }
    }

    protected static boolean isInitialized() {
        return _tableDbNameInstanceMap.size() == _tableDbNameClassNameMap
                .size();
    }

    // ===================================================================================
    //                                                                  Provider Singleton
    //                                                                  ==================
    protected static final DBMetaProvider _provider = new DBMetaInstanceHandler();

    public static DBMetaProvider getProvider() {
        return _provider;
    }

    @Override
    public DBMeta provideDBMeta(final String tableFlexibleName) {
        return byTableFlexibleName(tableFlexibleName);
    }

    @Override
    public DBMeta provideDBMeta(final Class<?> entityType) {
        return byEntityType(entityType);
    }

    @Override
    public DBMeta provideDBMetaChecked(final String tableFlexibleName) {
        return findDBMeta(tableFlexibleName);
    }

    @Override
    public DBMeta provideDBMetaChecked(final Class<?> entityType) {
        return findDBMeta(entityType);
    }

    // ===================================================================================
    //                                                                         Find DBMeta
    //                                                                         ===========
    /**
     * Find DB meta by table flexible name. (accept quoted name and schema prefix)
     * @param tableFlexibleName The flexible name of table. (NotNull)
     * @return The instance of DB meta. (NotNull)
     * @exception org.seasar.dbflute.exception.DBMetaNotFoundException When the DB meta is not found.
     */
    public static DBMeta findDBMeta(final String tableFlexibleName) {
        final DBMeta dbmeta = byTableFlexibleName(tableFlexibleName);
        if (dbmeta == null) {
            final String msg = "The DB meta was not found by the table flexible name: key="
                    + tableFlexibleName;
            throw new DBMetaNotFoundException(msg);
        }
        return dbmeta;
    }

    /**
     * Find DB meta by entity type.
     * @param entityType The entity type of table, which should implement the {@link Entity} interface. (NotNull)
     * @return The instance of DB meta. (NotNull)
     * @exception org.seasar.dbflute.exception.DBMetaNotFoundException When the DB meta is not found.
     */
    public static DBMeta findDBMeta(final Class<?> entityType) {
        final DBMeta dbmeta = byEntityType(entityType);
        if (dbmeta == null) {
            final String msg = "The DB meta was not found by the entity type: key="
                    + entityType;
            throw new DBMetaNotFoundException(msg);
        }
        return dbmeta;
    }

    // ===================================================================================
    //                                                                       by Table Name
    //                                                                       =============
    /**
     * @param tableFlexibleName The flexible name of table. (NotNull)
     * @return The instance of DB meta. (NullAllowed: If the DB meta is not found, it returns null)
     */
    protected static DBMeta byTableFlexibleName(final String tableFlexibleName) {
        assertStringNotNullAndNotTrimmedEmpty("tableFlexibleName",
                tableFlexibleName);
        String tableDbName = _tableDbNameFlexibleMap.get(tableFlexibleName);
        if (tableDbName == null) {
            tableDbName = retryByNormalizedName(tableFlexibleName);
        }
        return tableDbName != null ? byTableDbName(tableDbName) : null;
    }

    protected static String retryByNormalizedName(final String tableFlexibleName) {
        String tableDbName = null;
        final String pureName = normalizeTableFlexibleName(tableFlexibleName);
        final String schema = extractSchemaIfExists(tableFlexibleName);
        if (schema != null) { // first, find by qualified name
            tableDbName = _tableDbNameFlexibleMap.get(schema + "." + pureName);
        }
        if (tableDbName == null) { // next, find by pure name
            tableDbName = _tableDbNameFlexibleMap.get(pureName);
        }
        return tableDbName;
    }

    protected static String normalizeTableFlexibleName(
            final String tableFlexibleName) {
        return removeQuoteIfExists(removeSchemaIfExists(tableFlexibleName));
    }

    protected static String removeQuoteIfExists(final String name) {
        if (name.startsWith("\"") && name.endsWith("\"")) {
            return strip(name);
        } else if (name.startsWith("[") && name.endsWith("]")) {
            return strip(name);
        }
        return name;
    }

    protected static String removeSchemaIfExists(final String name) {
        final int dotLastIndex = name.lastIndexOf(".");
        return dotLastIndex >= 0 ? name.substring(dotLastIndex + ".".length())
                : name;
    }

    protected static String extractSchemaIfExists(final String name) {
        final int dotLastIndex = name.lastIndexOf(".");
        return dotLastIndex >= 0 ? name.substring(0, dotLastIndex) : null;
    }

    protected static String strip(final String name) {
        return name.substring(1, name.length() - 1);
    }

    /**
     * @param tableDbName The DB name of table. (NotNull)
     * @return The instance of DB meta. (NullAllowed: If the DB meta is not found, it returns null)
     */
    protected static DBMeta byTableDbName(final String tableDbName) {
        assertStringNotNullAndNotTrimmedEmpty("tableDbName", tableDbName);
        return getCachedDBMeta(tableDbName);
    }

    // ===================================================================================
    //                                                                      by Entity Type
    //                                                                      ==============
    /**
     * @param entityType The entity type of table, which should implement the entity interface. (NotNull)
     * @return The instance of DB meta. (NullAllowed: If the DB meta is not found, it returns null)
     */
    protected static DBMeta byEntityType(final Class<?> entityType) {
        assertObjectNotNull("entityType", entityType);
        return getCachedDBMeta(entityType);
    }

    // ===================================================================================
    //                                                                       Cached DBMeta
    //                                                                       =============
    protected static DBMeta getCachedDBMeta(final String tableDbName) { // lazy-load (thank you koyak!)
        DBMeta dbmeta = _tableDbNameInstanceMap.get(tableDbName);
        if (dbmeta != null) {
            return dbmeta;
        }
        synchronized (_tableDbNameInstanceMap) {
            dbmeta = _tableDbNameInstanceMap.get(tableDbName);
            if (dbmeta != null) {
                // an other thread might have initialized
                // or reading might failed by same-time writing
                return dbmeta;
            }
            final String dbmetaName = _tableDbNameClassNameMap.get(tableDbName);
            if (dbmetaName == null) {
                return null;
            }
            _tableDbNameInstanceMap.put(tableDbName,
                    toDBMetaInstance(dbmetaName));
            return _tableDbNameInstanceMap.get(tableDbName);
        }
    }

    protected static DBMeta toDBMetaInstance(final String dbmetaName) {
        try {
            final Class<?> dbmetaType = Class.forName(dbmetaName);
            final Method method = dbmetaType.getMethod("getInstance",
                    (Class[]) null);
            final Object result = method.invoke(null, (Object[]) null);
            return (DBMeta) result;
        } catch (final Exception e) {
            final String msg = "Failed to get the instance: " + dbmetaName;
            throw new IllegalStateException(msg, e);
        }
    }

    protected static DBMeta getCachedDBMeta(final Class<?> entityType) { // lazy-load same as by-name
        DBMeta dbmeta = _entityTypeInstanceMap.get(entityType);
        if (dbmeta != null) {
            return dbmeta;
        }
        synchronized (_entityTypeInstanceMap) {
            dbmeta = _entityTypeInstanceMap.get(entityType);
            if (dbmeta != null) {
                // an other thread might have initialized
                // or reading might failed by same-time writing
                return dbmeta;
            }
            if (Entity.class.isAssignableFrom(entityType)) { // required
                final Entity entity = newEntity(entityType);
                dbmeta = getCachedDBMeta(entity.getTableDbName());
            }
            if (dbmeta == null) {
                return null;
            }
            _entityTypeInstanceMap.put(entityType, dbmeta);
            return _entityTypeInstanceMap.get(entityType);
        }
    }

    protected static Entity newEntity(final Class<?> entityType) {
        try {
            return (Entity) entityType.newInstance();
        } catch (final Exception e) {
            final String msg = "Failed to new the instance: " + entityType;
            throw new IllegalStateException(msg, e);
        }
    }

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    protected static <KEY, VALUE> HashMap<KEY, VALUE> newHashMap() {
        return new HashMap<KEY, VALUE>();
    }

    // -----------------------------------------------------
    //                                         Assert Object
    //                                         -------------
    protected static void assertObjectNotNull(final String variableName,
            final Object value) {
        DfAssertUtil.assertObjectNotNull(variableName, value);
    }

    // -----------------------------------------------------
    //                                         Assert String
    //                                         -------------
    protected static void assertStringNotNullAndNotTrimmedEmpty(
            final String variableName, final String value) {
        DfAssertUtil.assertStringNotNullAndNotTrimmedEmpty(variableName, value);
    }
}
