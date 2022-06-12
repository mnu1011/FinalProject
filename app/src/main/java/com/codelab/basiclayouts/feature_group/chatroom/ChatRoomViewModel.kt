package com.codelab.basiclayouts.feature_group.chatroom

import androidx.annotation.DrawableRes
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.codelab.basiclayouts.R
import com.codelab.basiclayouts.core.domain.use_case.AccountingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val accountingUseCases: AccountingUseCases
) : ViewModel() {
    private val _groupMessages = getMessageHistoryData().toMutableStateList()
    val groupMessages: List<MessageData>
        get() = _groupMessages

    fun sendMessage(inputValue: String) {}
}

private fun getMessageHistoryData(): List<MessageData>{
    return messageList
}

data class MessageData(
    @DrawableRes val profile: Int,
    val userId: Int,
    val message: String
)

val messageList = listOf(
    MessageData(R.drawable.friend_1, 1, "There are 5 tasks remaining."),
    MessageData(R.drawable.member_1, 2, "Let's go!"),
    MessageData(R.drawable.friend_2, 3, "You forgot to record your breakfast")
)