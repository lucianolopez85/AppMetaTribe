package com.metatribe.content.feed.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.metatribe.content.feed.R
import com.metatribe.content.feed.domain.vo.PostVO
import com.metatribe.content.feed.extension.base64ToBitmap

class HomeAdapter : ListAdapter<PostVO, HomeAdapter.PostViewHolder>(PostDiffCallback()) {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgAvatar: ImageView = itemView.findViewById(R.id.imgAvatar)
        private val txtName: TextView = itemView.findViewById(R.id.txtName)
        private val imgPost: ImageView = itemView.findViewById(R.id.imgPost)
        private val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)

        fun bind(post: PostVO) {
            txtName.text = post.userName
            txtDescription.text = post.descriptionPost
            val avatarBitmap = base64ToBitmap(post.userImageAvatar)
            Glide.with(itemView.context)
                .load(avatarBitmap)
                .circleCrop()
                .into(imgAvatar)

            Glide.with(itemView.context)
                .load(base64ToBitmap(post.imagePost))
                .into(imgPost)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

