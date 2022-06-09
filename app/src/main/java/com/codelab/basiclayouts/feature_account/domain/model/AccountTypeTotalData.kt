package com.codelab.basiclayouts.feature_account.domain.model

import androidx.compose.ui.graphics.Color

data class AccountTypeTotalData(
    val type: String,
    val percent: Float,
    val color: Color,
    val money: Int
)