package com.example.a581kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a582kotlin.R
import com.google.android.material.imageview.ShapeableImageView

class StoriesAdapter(var context: Context, var storiesList: ArrayList<Stories>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stories, parent, false)
        return StoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val stories = storiesList[position]
        if (holder is StoriesViewHolder) {
            holder.profile.setImageResource(stories.profile)
            holder.fullname.text = stories.fullname
        }
    }

    override fun getItemCount(): Int {
        return storiesList.size
    }

    inner class StoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profile: ShapeableImageView = itemView.findViewById(R.id.stories_iv_profile_id)
        var fullname: TextView = itemView.findViewById(R.id.stories_tv_fullname_id)
    }
}