package com.metatribe.content.feed.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.metatribe.content.feed.R
import com.metatribe.content.feed.domain.vo.ObjectiveVO

class ObjectiveAdapter(
    private val objectives: List<ObjectiveVO>
) : RecyclerView.Adapter<ObjectiveAdapter.ObjectiveViewHolder>() {

    inner class ObjectiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtObjetivo: TextView = itemView.findViewById(R.id.txt_objetivo)
        val txtFrequency: TextView = itemView.findViewById(R.id.txt_frequency)
        val txtProgress: TextView = itemView.findViewById(R.id.txt_progress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectiveViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_objetivo, parent, false)
        return ObjectiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObjectiveViewHolder, position: Int) {
        val objective = objectives[position]
        holder.txtObjetivo.text = objective.title
        holder.txtFrequency.text = " ${objective.frequency}x na semana"
        holder.txtProgress.text = "${objective.progress}%"
    }

    override fun getItemCount(): Int = objectives.size
}
