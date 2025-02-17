package com.example.android.navigationadvancedsample.formscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.navigationadvancedsample.R

class Register : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        (view.findViewById<View>(R.id.signup_btn) as Button).setOnClickListener {
            this@Register.findNavController().navigate(R.id.action_register_to_registered)
        }
        return view
    }
}
