package com.metatribe.content.feed.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.metatribe.content.feed.R
import com.metatribe.content.feed.domain.vo.ProfileMedalVO

class ProfileMedalAdapter(
    private val items: List<ProfileMedalVO>
) : RecyclerView.Adapter<ProfileMedalAdapter.MedalViewHolder>() {

    inner class MedalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMedal: ImageView = itemView.findViewById(R.id.img_profile_medal)
        val txtTitle: TextView = itemView.findViewById(R.id.txt_title_profile_medal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_medal, parent, false)
        return MedalViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        val item = items[position]
        holder.imgMedal.setImageResource(item.imageResId)
        holder.txtTitle.text = item.title
    }

    override fun getItemCount(): Int = items.size
}
