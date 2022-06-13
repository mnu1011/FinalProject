package com.codelab.basiclayouts.feature_account.presentation.homepage

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codelab.basiclayouts.R
import com.codelab.basiclayouts.core.domain.use_case.AccountingUseCases
import com.codelab.basiclayouts.feature_account.domain.model.FriendInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    private val accountingUseCases: AccountingUseCases
) : ViewModel() {
    private val _friendList = getFriendData().toMutableStateList()

    val friendList: List<FriendInfo>
        get() = _friendList

    init {
        viewModelScope.launch {
            accountingUseCases.cardInit()
        }
    }

    // 下面這是展示用 到時候要移到初始頁面initialize卡片
//    fun addCards(){
//        viewModelScope.launch {
//            accountingUseCases.cardInit()
//        }
//    }
}

private fun getFriendData(): List<FriendInfo>{
    return friendsList
}