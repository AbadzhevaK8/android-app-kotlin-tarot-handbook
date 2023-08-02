package com.k8abadzheva.tarothandbook.ui

import android.content.Intent
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

    private var cardImageResourceId: Int = 0
    private var cardTitleResourceId: Int = 0
    private var cardInterpretationResourceId: Int = 0

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

            cardImageResourceId = it.imageResourceId
            cardTitleResourceId = it.titleResourceId
            cardInterpretationResourceId = it.interpretationResourceId

            binding.cardImage.load(it.imageResourceId)
            binding.cardTitle.text = getString(it.titleResourceId)
            binding.cardInterpretation.text = getString(it.interpretationResourceId)

        }

        val shareBtn = binding.shareButton
        shareBtn.setOnClickListener {
            shareCard()
        }
    }

    private fun shareCard() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val cardText = getString(cardTitleResourceId) + "\n\n" + getString(cardInterpretationResourceId)
        intent.putExtra(Intent.EXTRA_TEXT, cardText)

        if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
            startActivity(Intent.createChooser(intent, "Поделиться с помощью"))
        }
    }
}