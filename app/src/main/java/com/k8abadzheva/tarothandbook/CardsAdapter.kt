package com.k8abadzheva.tarothandbook

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.k8abadzheva.tarothandbook.databinding.CardsListItemBinding
import com.k8abadzheva.tarothandbook.model.Card

class CardsAdapter(private val onItemClicked: (Card) -> Unit) :
        ListAdapter<Card, CardsAdapter.CardsViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class CardsViewHolder(private var binding: CardsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(card: Card, context: Context) {
            binding.title.text = context.getString(card.titleResourceId)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardsViewHolder {
        context = parent.context
        return CardsViewHolder(
            CardsListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current, context)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Card>() {
            override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
                return (oldItem.id == newItem.id ||
                        oldItem.titleResourceId == newItem.titleResourceId
                        )
            }

            override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
                return oldItem == newItem
            }
        }
    }
}