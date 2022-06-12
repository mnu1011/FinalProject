package com.codelab.basiclayouts.feature_cards.presentation

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.codelab.basiclayouts.core.domain.use_case.AccountingUseCases
import com.codelab.basiclayouts.feature_account.domain.model.PetCard
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val accountingUseCases: AccountingUseCases
) : ViewModel() {
    private val _petCardData = getPetCardData().toMutableStateList()
    val petCardData: List<PetCard>
        get() = _petCardData
}

private fun getPetCardData(): List<PetCard>{
    return cardList
}