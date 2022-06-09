/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codelab.basiclayouts.feature_account.presentation.graph.components.ExpenseGraphScreen
import com.codelab.basiclayouts.feature_account.presentation.graph.components.IncomeGraphScreen
import com.codelab.basiclayouts.feature_account.presentation.homepage.HomepageViewModel
import com.codelab.basiclayouts.feature_account.presentation.homepage.component.HomepageScreen
import com.codelab.basiclayouts.feature_account.presentation.record_list.components.RecordScreen
import com.codelab.basiclayouts.feature_account.presentation.search_filter.components.FilterResultScreen
import com.codelab.basiclayouts.feature_account.presentation.search_filter.components.FilterScreen
import com.codelab.basiclayouts.feature_account.presentation.search_filter.components.SearchScreen
import com.codelab.basiclayouts.feature_account.presentation.track_expense.component.RecordingPageScreen
import com.codelab.basiclayouts.feature_cards.presentation.card.components.CardScreen
import com.codelab.basiclayouts.feature_cards.presentation.cardList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
            // RecordingPageScreen()  // 記帳頁面 日曆功能no
            // HomepageScreen()  // 好友頁面no
            // RecordScreen() // ok
            // SearchScreen() // ok
            // FilterScreen() // ok
            // FilterResultScreen() // ok
            // ExpenseGraphScreen() // ok
            // IncomeGraphScreen() // ok
            // CardCollectionScreen() // ok
            // CardScreen(petCard = cardList[3]) // 到時候要改成傳id進去 從viewModel中拿卡
        }
    }
}

