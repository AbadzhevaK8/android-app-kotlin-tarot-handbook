package com.k8abadzheva.tarothandbook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.k8abadzheva.tarothandbook.data.CardsData
import com.k8abadzheva.tarothandbook.model.Card

class CardsViewModel : ViewModel() {
    private var _currentCard: MutableLiveData<Card> = MutableLiveData<Card>()
    val currentCard: LiveData<Card>
        get() = _currentCard

    private var _cardsData: ArrayList<Card> = ArrayList()
    val cardsData: ArrayList<Card>
        get() = _cardsData

    init {
        _cardsData = CardsData.getCardsData()
        _currentCard.value = _cardsData[0]
    }

    fun updateCurrentCard(card: Card) {
        _currentCard.value = card
    }
}