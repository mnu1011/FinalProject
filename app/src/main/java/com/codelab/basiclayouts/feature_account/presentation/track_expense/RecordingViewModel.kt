package com.codelab.basiclayouts.feature_account.presentation.track_expense

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class RecordingViewModel: ViewModel() {
//    private var _record by mutableStateOf(TrackInfo())
//    val record: TrackInfo()
//            get() = _record

    private val _typeData = getTypeData().toMutableStateList()
    val typeData: List<String>
        get() = _typeData

    private var _typeChoose by mutableStateOf("飲食")
    val typeChoose: String
        get() = _typeChoose

    fun typeChange(type: String) {
        _typeChoose = type
    }

}

private fun getTypeData(): List<String> {
    return listOf("飲食","交通","娛樂","購物","學習","租金","水電","投資")
}