package com.k8abadzheva.tarothandbook.ui

import android.content.Context
import android.widget.TextView
import com.k8abadzheva.tarothandbook.R
import com.k8abadzheva.tarothandbook.databinding.CardsListItemBinding
import com.k8abadzheva.tarothandbook.model.Card
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CardsAdapter(private val onItemClicked: (Card) -> Unit) : GroupAdapter<GroupieViewHolder>() {

    fun setData(context: Context, cards: List<Card>) {
        // Clear the adapter before adding new items
        clear()

        // Separate cards into groups based on arcanaResourceId
        val groupedCards = cards.groupBy { it.arcanaResourceId }

        // Iterate through each group and add arcana header and cards
        groupedCards.forEach { (arcana, cardsInArcana) ->
            add(ArcanaHeaderItem(context.getString(arcana)))
            cardsInArcana.forEach { card ->
                add(CardItem(card, context, onItemClicked))
            }
        }
    }
}


class ArcanaHeaderItem(private val title: String) : Item<GroupieViewHolder>() {
    override fun getLayout() = R.layout.arcana_header_item

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.textArcanaHeader).text = title
    }
}


class CardItem(
    private val card: Card,
    private val context: Context,
    private val onItemClicked: (Card) -> Unit
) : Item<GroupieViewHolder>() {
    override fun getLayout() = R.layout.cards_list_item

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val binding = CardsListItemBinding.bind(viewHolder.itemView)
        binding.title.text = context.getString(card.titleResourceId)

        viewHolder.itemView.setOnClickListener {
            onItemClicked(card)
        }
    }
}
