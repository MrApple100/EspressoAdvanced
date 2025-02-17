package com.example.android.navigationadvancedsample.listscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigationadvancedsample.R

class Leaderboard : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_leaderboard, container, false)
        val count: Byte = 10
        val persons = arrayOfNulls<String>(count.toInt())
        for (i in 0 until count) {
            val var13 = "Person " + (i + 1)
            persons[i] = var13
        }
        val personAdapter = MyAdapter(persons)
        val rvPersons = view.findViewById<RecyclerView>(R.id.leaderboard_list)
        rvPersons.setHasFixedSize(true)
        rvPersons.adapter = personAdapter
        return view
    }

    internal inner class MyAdapter(private val myDataset: Array<String?>) :
        RecyclerView.Adapter<MyAdapter.ViewHolder>() {
        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        // Each data item is just a string in this case that is shown in a TextView.
        inner class ViewHolder(val item: View) : RecyclerView.ViewHolder(item)

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_view_item, parent, false)
            return ViewHolder(itemView)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            (holder.item.findViewById<View>(R.id.user_name_text) as TextView).text =
                myDataset[position]
            (holder.item.findViewById<View>(R.id.user_avatar_image) as ImageView)
                .setImageResource(listOfAvatars[position % listOfAvatars.size])
            holder.item.setOnClickListener {
                val bundle = bundleOf("userName" to myDataset[position])
                holder.item.findNavController()
                    .navigate(R.id.action_leaderboard_to_userProfile, bundle)
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount(): Int {
            return myDataset.size
        }


    }

    private val listOfAvatars = intArrayOf(
        R.drawable.avatar_1_raster,
        R.drawable.avatar_2_raster,
        R.drawable.avatar_3_raster,
        R.drawable.avatar_4_raster,
        R.drawable.avatar_5_raster,
        R.drawable.avatar_6_raster
    )
}
