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

package jp.sf.fess.helper.impl;

import jp.sf.fess.helper.DatabaseHelper;

import org.codelibs.robot.service.DataService;
import org.codelibs.robot.service.UrlFilterService;
import org.codelibs.robot.service.UrlQueueService;

public class DatabaseHelperImpl implements DatabaseHelper {

    public DataService dataService;

    public UrlQueueService urlQueueService;

    public UrlFilterService urlFilterService;

    @Override
    public void optimize() {
        urlQueueService.deleteAll();
        dataService.deleteAll();
        urlFilterService.deleteAll();
    }

}
