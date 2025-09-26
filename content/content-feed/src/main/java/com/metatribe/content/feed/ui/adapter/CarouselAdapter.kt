package com.metatribe.content.feed.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.metatribe.content.feed.R
import com.metatribe.content.feed.domain.vo.CarouselItem

class CarouselAdapter (
    private val items: List<CarouselItem>,
    private val onItemClick: (CarouselItem) -> Unit
) : RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    inner class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val img = itemView.findViewById<ImageView>(R.id.img_card_carousel)
        private val title = itemView.findViewById<TextView>(R.id.txt_title_card_carousel)
        private val location = itemView.findViewById<TextView>(R.id.txt_location_card_carousel)
        private val members = itemView.findViewById<TextView>(R.id.txt_members_card_carousel)
        private val days = itemView.findViewById<TextView>(R.id.txt_active_days_card_carousel)

        fun bind(item: CarouselItem) {
            Glide.with(itemView.context)
                .load(item.imageResId)
                .into(img)

            title.text = item.title
            location.text = item.location
            members.text = "${item.members} membros"
            days.text = "${item.activeDays} dias ativos"

            itemView.setOnClickListener { onItemClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carousel, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}

