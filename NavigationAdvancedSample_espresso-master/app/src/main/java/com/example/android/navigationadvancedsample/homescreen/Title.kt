package com.example.android.navigationadvancedsample.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.navigationadvancedsample.R

class Title : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_title, container, false)

        //////////////////////
        val viewById = view.findViewById<View>(R.id.game_title) as TextView
        val intent = requireActivity().intent
        if (intent.hasExtra("EXTRA")) {
            val inputData = intent.extras
            val input = inputData!!.getString("EXTRA")
            viewById.text = input
        }
        ////////////////////////
        view.findViewById<View>(R.id.about_btn).setOnClickListener {
            this@Title.findNavController().navigate(R.id.action_title_to_about)
        }
        return view
    }
}
