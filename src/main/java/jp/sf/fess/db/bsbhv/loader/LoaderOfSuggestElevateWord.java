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

package jp.sf.fess.db.bsbhv.loader;

import java.util.List;

import jp.sf.fess.db.exbhv.SuggestElevateWordBhv;
import jp.sf.fess.db.exentity.SuggestElevateWord;

import org.seasar.dbflute.BehaviorSelector;

/**
 * The referrer loader of SUGGEST_ELEVATE_WORD as TABLE. <br />
 * <pre>
 * [primary key]
 *     ID
 *
 * [column]
 *     ID, SUGGEST_WORD, READING, TARGET_ROLE, TARGET_LABEL, BOOST, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME, DELETED_BY, DELETED_TIME, VERSION_NO
 *
 * [sequence]
 *
 *
 * [identity]
 *     ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *
 *
 * [referrer table]
 *
 *
 * [foreign property]
 *
 *
 * [referrer property]
 *
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfSuggestElevateWord {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<SuggestElevateWord> _selectedList;

    protected BehaviorSelector _selector;

    protected SuggestElevateWordBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfSuggestElevateWord ready(
            final List<SuggestElevateWord> selectedList,
            final BehaviorSelector selector) {
        _selectedList = selectedList;
        _selector = selector;
        return this;
    }

    protected SuggestElevateWordBhv myBhv() {
        if (_myBhv != null) {
            return _myBhv;
        } else {
            _myBhv = _selector.select(SuggestElevateWordBhv.class);
            return _myBhv;
        }
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<SuggestElevateWord> getSelectedList() {
        return _selectedList;
    }

    public BehaviorSelector getSelector() {
        return _selector;
    }
}
