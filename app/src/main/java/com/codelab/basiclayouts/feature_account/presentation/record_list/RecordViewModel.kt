package com.codelab.basiclayouts.feature_account.presentation.record_list

import android.os.Build
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.codelab.basiclayouts.feature_account.domain.model.AccountRecord
import com.codelab.basiclayouts.feature_account.domain.model.AccountType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RecordViewModel: ViewModel() {
    private val _recordData = getRecordData().toMutableStateList()

    private var _currentDate by mutableStateOf(getCurrentDate())


    val recordData: List<AccountRecord>
        get() = _recordData

    val currentDate: Date
        get() = _currentDate

    fun updateCurrentDate(year: String, month: String, day: String){
        _currentDate.year = year
        _currentDate.month = month
        _currentDate.day = day
    }
}

private fun getCurrentDate(): Date {
    val current = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDateTime.now()

    } else {
        TODO("VERSION.SDK_INT < O")
    }
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    val formatted = current.format(formatter)
    return Date(
        formatted.substring(0, 4),
        formatted.substring(5, 7),
        formatted.substring(8, 10)
    )
}

private fun getRecordData(): List<AccountRecord>{
    return listOf(
        AccountRecord(
            AccountType.FOOD,
            "Bubble Tea",
            50,
            "2022/6/4/10:52",
            "飲食"
        ),
        AccountRecord(
            AccountType.LOTTERY,
            "Lottery",
            1000,
            "2022/6/4/11:33",
            "獎金"
        ),
        AccountRecord(
            AccountType.FOOD,
            "Pizza",
            200,
            "2022/6/4/20:19",
            "飲食"
        ),
        AccountRecord(
            AccountType.CLOTHS,
            "T-shirt",
            500,
            "2022/6/4/21:29",
            "服裝"
        ),
        AccountRecord(
            AccountType.EDUCATION,
            "Book_A",
            3000,
            "2022/6/4/23:12",
            "教育"
        ),
    )
}

data class Date(
    var year: String = "2022",
    var month: String = "06",
    var day: String = "17"
)