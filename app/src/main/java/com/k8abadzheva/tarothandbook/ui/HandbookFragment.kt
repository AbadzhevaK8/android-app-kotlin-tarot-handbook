package com.k8abadzheva.tarothandbook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.k8abadzheva.tarothandbook.CardsViewModel
import com.k8abadzheva.tarothandbook.R
import com.k8abadzheva.tarothandbook.databinding.FragmentHandbookBinding

class HandbookFragment : Fragment() {

    private val cardsViewModel: CardsViewModel by activityViewModels()
    private lateinit var adapter: CardsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentHandbookBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHandbookBinding.bind(view)

        adapter = CardsAdapter { card ->
            cardsViewModel.updateCurrentCard(card)
            this.findNavController().navigate(R.id.action_HandbookFragment_to_CardFragment)
        }
        binding.recyclerView.adapter = adapter
        adapter.setData(requireContext(), cardsViewModel.cardsData)
    }
}

