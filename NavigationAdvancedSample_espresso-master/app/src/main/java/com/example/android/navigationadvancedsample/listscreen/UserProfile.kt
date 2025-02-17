package com.example.android.navigationadvancedsample.listscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.android.navigationadvancedsample.R
import com.example.android.navigationadvancedsample.listscreen.Leaderboard.MyAdapter

class UserProfile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_profile, container, false)
        var name: String? = "Ali Connors"
        if (arguments != null) {
            name = requireArguments().getString("userName")
        }
        (view.findViewById<View>(R.id.profile_user_name) as TextView).text = name
        return view
    }
}
