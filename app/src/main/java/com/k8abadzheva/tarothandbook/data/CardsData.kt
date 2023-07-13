package com.k8abadzheva.tarothandbook.data

import com.k8abadzheva.tarothandbook.R
import com.k8abadzheva.tarothandbook.model.Card

object CardsData{
    fun getCardsData(): ArrayList<Card> {
        return arrayListOf(
            Card(
                id = 1,
                titleResourceId = R.string.title_fool,
                interpretationResourceId = R.string.interpretation_fool,
                arcanaResourceId = R.string.major,
                imageResourceId = R.drawable.rwfool
            ),
            Card(
                id = 2,
                titleResourceId = R.string.title_magician,
                interpretationResourceId = R.string.interpretation_magician,
                arcanaResourceId = R.string.major,
                imageResourceId = R.drawable.rwmagician
            )
        )
    }
}
