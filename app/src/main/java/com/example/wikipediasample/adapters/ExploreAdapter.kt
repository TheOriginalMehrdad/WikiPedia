package com.example.wikipediasample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipediasample.data.ItemPost
import com.example.wikipediasample.databinding.ExploreCardViewBinding

class ExploreAdapter(private val data: ArrayList<ItemPost>) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    private lateinit var binding: ExploreCardViewBinding

    inner class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: ItemPost) {

            binding.txTitle.text = itemPost.textTitle
            binding.txtSubtitle.text = itemPost.textSubtitle
            binding.txtDescription.text = itemPost.textDescription

            Glide
                .with(itemView.context)
                .load(itemPost.urlImage)
                .into(binding.imgExplore)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ExploreCardViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ExploreViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindViews(data[position])
    }
}