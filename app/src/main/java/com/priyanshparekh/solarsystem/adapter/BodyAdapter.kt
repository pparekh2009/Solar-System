package com.priyanshparekh.solarsystem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.priyanshparekh.solarsystem.R
import com.priyanshparekh.solarsystem.databinding.LayoutBodyItemBinding
import com.priyanshparekh.solarsystem.model.Body
import com.priyanshparekh.solarsystem.model.Planet

class BodyAdapter(private val bodies: List<Body>): RecyclerView.Adapter<BodyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_body_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val body: Body = bodies[position]
        holder.tvBodyName.text = body.englishName
    }

    override fun getItemCount(): Int {
        return bodies.size
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var binding: LayoutBodyItemBinding = LayoutBodyItemBinding.bind(itemView)
        val tvBodyName: TextView = binding.tvBodyName
    }
}