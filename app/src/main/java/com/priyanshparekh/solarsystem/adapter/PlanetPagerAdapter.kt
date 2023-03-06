package com.priyanshparekh.solarsystem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.priyanshparekh.solarsystem.R
import com.priyanshparekh.solarsystem.databinding.LayoutBodyItemBinding
import com.priyanshparekh.solarsystem.helper.HelperResizer
import com.priyanshparekh.solarsystem.interfaces.OnItemClickListener

class PlanetPagerAdapter(private val bodies: List<Int>, private val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<PlanetPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_body_item, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.planetImage.setImageResource(bodies[position])
    }

    override fun getItemCount(): Int {
        return bodies.size
    }

    class ViewHolder(itemView: View, private val onItemClickListener: OnItemClickListener): RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val binding: LayoutBodyItemBinding = LayoutBodyItemBinding.bind(itemView)

        val bodyName: TextView = binding.tvBodyName
        val planetImage: ImageView = binding.ivPlanetImage

        init {
            HelperResizer.getHeightAndWidth(itemView.context)
            HelperResizer.setSize(planetImage, 900, 900)

            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            onItemClickListener.onItemClicked(adapterPosition)
        }

    }
}