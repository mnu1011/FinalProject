package com.codelab.basiclayouts.feature_account.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FriendInfo(
    @StringRes val name: Int,
    @DrawableRes val avatar: Int,
    var intimacy: Int,
)