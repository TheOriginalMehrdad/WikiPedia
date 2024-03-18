package com.example.wikipediasample.utilities

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipediasample.data.ItemPost
import com.example.wikipediasample.databinding.TrendCardViewBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation


class TrendAdapter(private val data: ArrayList<ItemPost>, val itemInterface: ItemInterface) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {

    private lateinit var binding: TrendCardViewBinding

    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        
        @SuppressLint("SetTextI18n")
        fun bindViews(itemPost: ItemPost) {

            binding.textViewTitleITrend.text = itemPost.textTitle
            binding.textViewDescriptionTrend.text = itemPost.textSubtitle
            binding.textViewReachTrend.text = itemPost.insight
            binding.textViewNumberTrend.text = (adapterPosition + 1).toString()

            Glide
                .with(itemView.context)
                .load(itemPost.urlImage)
                .transform(RoundedCornersTransformation(22,1))
                .into(binding.imageViewTrendItem)

            itemView.setOnClickListener { itemInterface.onItemClicked(itemPost) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding = TrendCardViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return TrendViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bindViews(data[position])
    }
}