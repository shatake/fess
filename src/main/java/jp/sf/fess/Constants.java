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

package jp.sf.fess;

import java.util.regex.Pattern;

import org.codelibs.core.CoreLibConstants;
import org.codelibs.core.util.StringUtil;

public class Constants extends CoreLibConstants {
    public static final int MAJOR_VERSION = 9;

    public static final int MINOR_VERSION = 3;

    public static final String FESS_VERSION = String.valueOf(MAJOR_VERSION)
            + "." + String.valueOf(MINOR_VERSION);

    public static final String LINE_SEPARATOR = System
            .getProperty("line.separator");

    public static final int DEFAULT_ADMIN_PAGE_SIZE = 25;

    public static final String WEB_API_VERSION = FESS_VERSION;

    public static final String TRUE = "true";

    public static final String FALSE = "false";

    public static final String T = "T";

    public static final String F = "F";

    public static final String ON = "on";

    public static final String ASC = "asc";

    public static final String DESC = "desc";

    public static final String READY = "ready";

    public static final String RUNNING = "running";

    public static final String DONE = "done";

    public static final String OK = "ok";

    public static final String FAIL = "fail";

    public static final String ITEM_LABEL = "label";

    public static final String ITEM_VALUE = "value";

    public static final String ITEM_NAME = "name";

    public static final String UTF_8 = "UTF-8";

    public static final String MS932 = "MS932";

    public static final String OPTIMIZE = "optimize";

    public static final String COMMIT = "commit";

    public static final String DEFAULT_CRON_EXPRESSION = "0 0 0 * * ?";

    public static final String DEFAULT_SEARCH_LOG_CRON_EXPRESSION = "0 * * * * ?";

    public static final String DEFAULT_DAILY_CRON_EXPRESSION = "0 0 0 * * ?";

    public static final String DEFAULT_HOURLY_CRON_EXPRESSION = "0 0 * * * ?";

    public static final int DEFAULT_INTERVAL_TIME_FOR_FS = 1000;

    public static final int DEFAULT_INTERVAL_TIME_FOR_WEB = 30000;

    public static final int DEFAULT_NUM_OF_THREAD_FOR_FS = 5;

    public static final int DEFAULT_NUM_OF_THREAD_FOR_WEB = 3;

    public static final long DEFAULT_CRAWLING_EXECUTION_INTERVAL = 5000L;

    public static final long DEFAULT_COMMIT_PER_COUNT = 0L;

    /** Solr Status: Active */
    public static final String ACTIVE = "ACTIVE";

    /** Solr Status: Inactive */
    public static final String INACTIVE = "INACTIVE";

    // fess properties
    public static final String USER_INFO_PROPERTY = "user.info";

    public static final String USER_FAVORITE_PROPERTY = "user.favorite";

    public static final String SEARCH_LOG_PROPERTY = "search.log";

    public static final String APPEND_QUERY_PARAMETER_PROPERTY = "append.query.parameter";

    public static final String DIFF_CRAWLING_PROPERTY = "crawling.diff";

    public static final String USE_ACL_AS_ROLE = "use.acl.as.role";

    public static final String CRAWLING_THREAD_COUNT_PROPERTY = "crawling.thread.count";

    public static final String DAY_FOR_CLEANUP_PROPERTY = "day.for.cleanup";

    public static final String COMMIT_PER_COUNT_PROPERTY = "commit.count";

    public static final String SERVER_ROTATION_PROPERTY = "server.rotation";

    public static final String WEB_API_XML_PROPERTY = "web.api.xml";

    public static final String WEB_API_JSON_PROPERTY = "web.api.json";

    public static final String WEB_API_SUGGEST_PROPERTY = "web.api.suggest";

    public static final String WEB_API_SPELLCHECK_PROPERTY = "web.api.spellcheck";

    public static final String WEB_API_ANALYSIS_PROPERTY = "web.api.analysis";

    public static final String WEB_DESIGN_EDITOR_PROPERTY = "design.editor";

    public static final String DEFAULT_LABEL_VALUE_PROPERTY = "label.value";

    public static final String SUPPORTED_SEARCH_FEATURE_PROPERTY = "search.feature";

    public static final String IGNORE_FAILURE_TYPE_PROPERTY = "failure.ignoretype";

    public static final String FAILURE_COUNT_THRESHOLD_PROPERTY = "failure.countthreshold";

    public static final String WEB_API_HOT_SEARCH_WORD_PROPERTY = "web.api.hotsearch";

    public static final String CSV_FILE_ENCODING_PROPERTY = "csv.file.encoding";

    public static final String PURGE_SEARCH_LOG_DAY_PROPERTY = "purge.searchlog.day";

    public static final String PURGE_USER_INFO_DAY_PROPERTY = "purge.userinfo.day";

    public static final String PURGE_JOB_LOG_DAY_PROPERTY = "purge.joblog.day";

    public static final String PURGE_BY_BOTS_PROPERTY = "purge.by.bots";

    public static final String SEARCH_FILE_PROXY_PROPERTY = "search.file.proxy";

    public static final String SEARCH_DESKTOP_PROPERTY = "search.desktop";

    public static final String SEARCH_FILE_LAUNCHER_PROPERTY = "search.file.launcher";

    public static final String NOTIFICATION_TO_PROPERTY = "notification.to";

    public static final String USE_BROWSER_LOCALE_FOR_SEARCH_PROPERTY = "search.use.browser.locale";

    public static final String SUGGEST_SEARCH_LOG_PROPERTY = "suggest.searchlog";

    public static final String PURGE_SUGGEST_SEARCH_LOG_DAY_PROPERTY = "purge.suggest.searchlog.day";

    public static final String AUTH_CIPHER = "authenticationCipher";

    public static final String RETURN_PATH = "jp.sf.fess.ReturnPath";

    public static final String HIGHLIGHT_QUERIES = "jp.sf.fess.Queries";

    public static final String FIELD_LOGS = "jp.sf.fess.FieldLogs";

    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    public static final int DONE_STATUS = 9999;

    public static final String SUPPORTED_SEARCH_WEB = "W";

    public static final String SUPPORTED_SEARCH_NONE = "n";

    public static final String DEFAULT_IGNORE_FAILURE_TYPE = StringUtil.EMPTY;

    public static final String DEFAULT_FAILURE_COUNT = "-1";

    public static final String DEFAULT_PURGE_DAY = "30";

    public static final String DEFAULT_PURGE_BY_BOTS = "BaiduMobaider,"
            + "Baiduspider," + "CCBot," + "Googlebot," + "ia_archive,"
            + "Mediapartners-Google," + "mobile goo," + "msnbot,"
            + "Slurp,Yeti";

    public static final String DEFAULT_FROM_EMAIL = "Administrator <root@localhost>";

    // info map

    public static final String CRAWLER_STATUS = "CrawlerStatus";

    public static final String CRAWLER_START_TIME = "CrawlerStartTime";

    public static final String CRAWLER_END_TIME = "CrawlerEndTime";

    public static final String CRAWLER_EXEC_TIME = "CrawlerExecTime";

    public static final String WEB_FS_CRAWLER_START_TIME = "WebFsCrawlStartTime";

    public static final String WEB_FS_CRAWLER_END_TIME = "WebFsCrawlEndTime";

    public static final String DATA_CRAWLER_START_TIME = "DataCrawlStartTime";

    public static final String DATA_CRAWLER_END_TIME = "DataCrawlEndTime";

    public static final String OPTIMIZE_START_TIME = "OptimizeStartTime";

    public static final String OPTIMIZE_END_TIME = "OptimizeEndTime";

    public static final String OPTIMIZE_EXEC_TIME = "OptimizeExecTime";

    public static final String COMMIT_START_TIME = "CommitStartTime";

    public static final String COMMIT_END_TIME = "CommitEndTime";

    public static final String COMMIT_EXEC_TIME = "CommitExecTime";

    public static final String WEB_FS_CRAWLING_EXEC_TIME = "WebFsCrawlExecTime";

    public static final String WEB_FS_INDEX_EXEC_TIME = "WebFsIndexExecTime";

    public static final String WEB_FS_INDEX_SIZE = "WebFsIndexSize";

    public static final String DATA_CRAWLING_EXEC_TIME = "DataCrawlExecTime";

    public static final String DATA_INDEX_EXEC_TIME = "DataIndexExecTime";

    public static final String DATA_INDEX_SIZE = "DataIndexSize";

    public static final String SESSION_ID = "sessionId";

    public static final String INDEXING_TARGET = "indexingTarget";

    public static final String DIGEST_PREFIX = "...";

    public static final String BASIC = "BASIC";

    public static final String DIGEST = "DIGEST";

    public static final String NTLM = "NTLM";

    public static final String SAMBA = "SAMBA";

    public static final String[] RESERVED = { "+", "-", "&&", "||", "!", "(",
            ")", "{", "}", "[", "]", "^", "~", "*", "?", "\\", ";", ":", "/" };

    public static final Pattern SOLR_FIELD_RESERVED_PATTERN = Pattern
            .compile("([+\\-!\\(\\){}\\[\\]^\"~\\\\:\\p{Zs}]|(&&)|(\\|\\|))"); // "*", "?",

    public static final Pattern SOLR_RANGE_FIELD_RESERVED_PATTERN = Pattern
            .compile("([!\\(\\){}\\[\\]\"~\\\\:\\p{Zs}]|(&&)|(\\|\\|))");

    public static final String SEARCH_LOG_ACCESS_TYPE = "searchLogAccessType";

    public static final String RESULTS_PER_PAGE = "resultsPerPage";

    public static final String USER_CODE = "userCode";

    public static final String SEARCH_FIELD_LOG_SEARCH_QUERY = "query";

    public static final String SEARCH_FIELD_LOG_SOLR_QUERY = "solrQuery";

    public static final String STATS_REPORT_TYPE = "reportType";

    public static final String RESULT_DOC_ID_CACHE = "resultDocIds";

    public static final String SCREEN_SHOT_PATH_CACHE = "screenShotPaths";

    public static final String CRAWLING_SESSION_SYSTEM_NAME = "system";

    // view parameters

    public static final String FACET_QUERY = "jp.sf.fess.tag.FacetQuery";

    public static final String MLT_QUERY = "jp.sf.fess.tag.MLTQuery";

    public static final String GEO_QUERY = "jp.sf.fess.tag.GeoQuery";

    public static final String FACET_FORM = "jp.sf.fess.tag.FacetForm";

    public static final String MLT_FORM = "jp.sf.fess.tag.MLTForm";

    public static final String GEO_FORM = "jp.sf.fess.tag.GeoForm";

    public static final String LABEL_VALUE_MAP = "jp.sf.fess.LabelValueMap";

    public static final String OPTION_QUERY_Q = "q";

    public static final String OPTION_QUERY_CQ = "cq";

    public static final String OPTION_QUERY_OQ = "oq";

    public static final String OPTION_QUERY_NQ = "nq";

    // job
    public static final String JOB_ID_PREFIX = "job";

    public static final String SCHEDULED_JOB = "scheduledJob";

    public static final String JOB_EXECUTOR_TYPE = "jobExecutor";

    public static final String DEFAULT_JOB_TARGET = "all";

    public static final String DEFAULT_JOB_SCRIPT_TYPE = "groovy";

    public static final int EXIT_OK = 0;

    public static final int EXIT_FAIL = 1;

    public static final String DCF = "dcf";

    public static final String ALL_LANGUAGES = "all";

    public static final String DEFAULT_OPERATOR = "defaultOperator";

    public static final String INVALID_NUMERIC_PARAMETER = "-1";

    public static final String NOW = "NOW";

}
