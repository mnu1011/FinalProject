package com.codelab.basiclayouts.feature_account.presentation.homepage

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.codelab.basiclayouts.R
import com.codelab.basiclayouts.feature_account.domain.model.FriendInfo

class HomepageViewModel: ViewModel() {
    private val _friendList = getFriendData().toMutableStateList()

    val friendList: List<FriendInfo>
        get() = _friendList
}

private fun getFriendData(): List<FriendInfo>{
    return listOf(
        FriendInfo(
            R.string.Wu,
            R.drawable.wu,
            91,
        ),
        FriendInfo(
            R.string.Sophia,
            R.drawable.sophia,
            72,
        ),
        FriendInfo(
            R.string.Lucy,
            R.drawable.lucy,
            65,
        ),
        FriendInfo(
            R.string.Alice,
            R.drawable.alice,
            57,
        ),
        FriendInfo(
            R.string.Christen,
            R.drawable.christen,
            51,
        ),
        FriendInfo(
            R.string.Sam,
            R.drawable.sam,
            48,
        ),
        FriendInfo(
            R.string.Jennifer,
            R.drawable.jennifer,
            40,
        ),
    )
}