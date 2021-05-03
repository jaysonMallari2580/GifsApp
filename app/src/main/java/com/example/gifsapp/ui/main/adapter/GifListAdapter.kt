package com.example.gifsapp.ui.main.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gifsapp.MainActivity
import com.example.gifsapp.R
import com.example.gifsapp.databinding.FragmentGifPageBinding
import com.example.gifsapp.databinding.GiphyItemBinding
import com.example.gifsapp.ui.main.MainFragment
import com.example.gifsapp.ui.main.MainViewModel
import com.example.gifsapp.ui.main.data.models.GifDTO
import kotlinx.coroutines.withContext

class GifListAdapter(val mGifList:List<GifDTO>): RecyclerView.Adapter<GifListAdapter.GifListHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifListHolder {
        return GifListHolder(GiphyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: GifListHolder, position: Int) {
        val gifItem = mGifList[position]
        holder.bindData(gifItem)

        holder.itemView.setOnClickListener{
            val url  = gifItem.images.original.url
            val bundle = bundleOf("url" to url)
            Navigation.findNavController(it).navigate(R.id.action_destination_main_fragment_to_destination_fragment_gif_page, bundle)

            println("clicked")
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