package com.metatribe.content.feed.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.metatribe.content.feed.R
import com.metatribe.content.feed.domain.vo.CarouselItem
import com.metatribe.content.feed.domain.vo.CommunityItem

class CommunityAdapter(
    private val items: List<CommunityItem.CarouselContainer>,
    private val onItemClick: (CarouselItem) -> Unit
) : RecyclerView.Adapter<CommunityAdapter.CarouselContainerViewHolder>() {

    inner class CarouselContainerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.txt_title_carousel_container)
        private val recycler = itemView.findViewById<RecyclerView>(R.id.recycler_view_carousel_container)

        fun bind(container: CommunityItem.CarouselContainer) {
            title.text = container.title
            recycler.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            recycler.adapter = CarouselAdapter(container.items, onItemClick)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselContainerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carousel_container, parent, false)
        return CarouselContainerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselContainerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
