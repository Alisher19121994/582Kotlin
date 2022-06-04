package com.example.a581kotlin

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.a582kotlin.R
import com.google.android.material.imageview.ShapeableImageView

class FeedsAdapter(var feedsList: ArrayList<Uri>) :
    RecyclerView.Adapter<FeedsAdapter.FeedsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeedsAdapter.FeedsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feeds, parent, false)
        return FeedsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedsAdapter.FeedsViewHolder, position: Int) {
        holder.posts_photo_id.setImageURI(feedsList[position])
    }

    override fun getItemCount(): Int {
        return feedsList.size
    }

    inner class FeedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var posts_photo_id: ShapeableImageView = itemView.findViewById(R.id.feeds_posts_photo_id)
    }
}