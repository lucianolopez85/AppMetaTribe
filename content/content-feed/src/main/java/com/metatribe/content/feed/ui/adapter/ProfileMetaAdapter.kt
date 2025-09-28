package com.metatribe.content.feed.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.metatribe.content.feed.R
import com.metatribe.content.feed.domain.vo.ProfileMetaVO
import com.metatribe.content.feed.extension.toMetaStatus

class ProfileMetaAdapter(
    private val metas: List<ProfileMetaVO>,
    private val onMetaClick: (Int) -> Unit
) : RecyclerView.Adapter<ProfileMetaAdapter.MetaViewHolder>() {

    private val checkedStates = BooleanArray(metas.size)

    inner class MetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMetaYear: TextView = itemView.findViewById(R.id.txt_meta_year)
        val imgMetaStatus: TextView = itemView.findViewById(R.id.img_status_meta_year)
        val containerStatus: View = itemView.findViewById(R.id.constraint_meta_year)
        fun bind(item:ProfileMetaVO) {
            val visual = item.status.toMetaStatus()
            imgMetaStatus.text = visual.emoji
            txtMetaYear.text = item.txtItemMeta
            containerStatus.setBackgroundResource(visual.colorRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_meta_year, parent, false)
        return MetaViewHolder(view)
    }

    override fun getItemCount() = metas.size

    override fun onBindViewHolder(holder: MetaViewHolder, position: Int) {
        holder.bind(metas[position])
    }
}