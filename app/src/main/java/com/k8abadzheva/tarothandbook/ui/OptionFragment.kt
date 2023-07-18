package com.k8abadzheva.tarothandbook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.k8abadzheva.tarothandbook.R


/**
 * A simple [Fragment] subclass.
 * Use the [OptionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OptionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option, container, false)
    }


}