package com.example.a17_sabaq

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvTitle: TextView = itemView.tvTitleItem
    fun populateModel(user: User, size: Int, position: Int, activity: MainActivity) {
        tvTitle.text = user.title

        itemView.tvTitleItem.setOnClickListener {
            itemView.tvTitleItem.setBackgroundResource(R.drawable.style_1)
            activity.onItemClick(position)
        }
    }
}