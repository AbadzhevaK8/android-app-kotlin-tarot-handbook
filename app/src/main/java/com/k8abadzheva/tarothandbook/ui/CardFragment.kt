package com.k8abadzheva.tarothandbook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.k8abadzheva.tarothandbook.CardsViewModel
import com.k8abadzheva.tarothandbook.databinding.FragmentCardBinding


class CardFragment : Fragment() {

    private val cardsViewModel: CardsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentCardBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCardBinding.bind(view)

        cardsViewModel.currentCard.observe(this.viewLifecycleOwner) {
            binding.cardImage.load(it.imageResourceId)
            binding.cardTitle.text = getString(it.titleResourceId)
            binding.cardInterpretation.text = getString(it.interpretationResourceId)
        }
    }
}