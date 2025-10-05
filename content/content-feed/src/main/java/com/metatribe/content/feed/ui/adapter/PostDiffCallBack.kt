package com.metatribe.content.feed.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.metatribe.content.feed.domain.vo.PostVO

class PostDiffCallback : DiffUtil.ItemCallback<PostVO>() {
    override fun areItemsTheSame(oldItem: PostVO, newItem: PostVO): Boolean {
        return oldItem.postId == newItem.postId
    }

    override fun areContentsTheSame(oldItem: PostVO, newItem: PostVO): Boolean {
        return oldItem == newItem
    }
}
