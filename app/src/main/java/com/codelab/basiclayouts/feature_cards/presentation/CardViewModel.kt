package com.codelab.basiclayouts.feature_cards.presentation

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.codelab.basiclayouts.feature_account.domain.model.PetCard

class CardViewModel: ViewModel() {
    private val _petCardData = getPetCardData().toMutableStateList()
    val petCardData: List<PetCard>
        get() = _petCardData
}

private fun getPetCardData(): List<PetCard>{
    return cardList
}