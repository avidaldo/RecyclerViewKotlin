package com.example.recyclerviewkotlin.flowerList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.R
import com.example.recyclerviewkotlin.data.Flower
import com.example.recyclerviewkotlin.data.IMAGE_NO_AVALIABLE_RESOURCE
import com.example.recyclerviewkotlin.databinding.FlowerItemBinding

class FlowersAdapter(private val onClick: (Flower) -> Unit) :
    ListAdapter<Flower, FlowersAdapter.FlowerViewHolder>(FlowerDiffCallback) {

    /* ViewHolder for Flower, takes in the inflated view and the onClick behavior. */
    class FlowerViewHolder(binding: FlowerItemBinding, val onClick: (Flower) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        private val flowerTextView = binding.flowerText
        private val flowerImageView = binding.flowerImage
        //private var currentFlower: Flower? = null

        init {
            binding.root.setOnClickListener {
                currentFlower?.let {
                    onClick(it)
                }
            }
        }

        /* Bind flower name and image. */
        fun bind(flower: Flower) {
            currentFlower = flower
            flowerTextView.text = flower.name
            flowerImageView.setImageResource(flower.image ?: IMAGE_NO_AVALIABLE_RESOURCE)
        }
    }

    /* Creates and inflates view and return FlowerViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FlowerViewHolder(
        FlowerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClick
    )

    /* Gets current flower and uses it to bind view. */
    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        val flower = getItem(position)
        holder.bind(flower)

    }
}

/*
object FlowerDiffCallback : DiffUtil.ItemCallback<Flower>() {
    override fun areItemsTheSame(oldItem: Flower, newItem: Flower): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Flower, newItem: Flower): Boolean {
        return oldItem.id == newItem.id
    }
}*/
