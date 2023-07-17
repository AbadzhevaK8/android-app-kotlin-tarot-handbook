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
            ),
            Card(
                id = 3,
                titleResourceId = R.string.title_high_priestess,
                interpretationResourceId = R.string.interpretation_high_priestess,
                arcanaResourceId = R.string.major,
                imageResourceId = R.drawable.rwhighpriestess
            ),
            Card(
                id = 4,
                titleResourceId = R.string.title_empress,
                interpretationResourceId = R.string.interpretation_empress,
                arcanaResourceId = R.string.major,
                imageResourceId = R.drawable.rwempress
            ),
            Card(
                id = 5,
                titleResourceId = R.string.title_emperor,
                interpretationResourceId = R.string.interpretation_emperor,
                arcanaResourceId = R.string.major,
                imageResourceId = R.drawable.rwemperor
            ),
            Card(
                id = 6,
                titleResourceId = R.string.title_hierophant,
                interpretationResourceId = R.string.interpretation_hierophant,
                arcanaResourceId = R.string.major,
                imageResourceId = R.drawable.rwhierophant
            )
        )
    }
}
