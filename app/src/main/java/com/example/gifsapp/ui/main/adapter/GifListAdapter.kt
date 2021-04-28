package com.example.gifsapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gifsapp.databinding.GiphyItemBinding
import com.example.gifsapp.ui.main.data.models.GifDTO

class GifListAdapter(val mGifList:List<GifDTO>): RecyclerView.Adapter<GifListAdapter.GifListHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifListHolder {
        return GifListHolder(GiphyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: GifListHolder, position: Int) {
        val gifItem = mGifList[position]
        holder.bindData(gifItem)

        holder.itemView.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return mGifList.size
    }

    class GifListHolder(val binding:GiphyItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bindData(gif : GifDTO){
            Glide.with(binding.giphyIv.context)
                .load(gif.images.original.url)
                .into(binding.giphyIv)
        }
    }
}