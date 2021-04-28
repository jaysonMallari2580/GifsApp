package com.example.gifsapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.gifsapp.databinding.MainFragmentBinding
import com.example.gifsapp.ui.main.adapter.CategoryListAdapter
import com.example.gifsapp.ui.main.adapter.GifListAdapter

class MainFragment : Fragment() {

    lateinit var binding: MainFragmentBinding


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        //top-image
        val url = "https://media2.giphy.com/headers/IntoAction/BM0R9Sycv4uM.gif"
        Glide.with(binding.topGiphy.context)
            .load(url)
            .into(binding.topGiphy)


        //category list
        binding.categoryListRecyclerview.apply {
            layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = CategoryListAdapter(viewModel.categoryList)
        }

        //trending list
        viewModel.giphyList.observe(viewLifecycleOwner, Observer {
            binding.giphyListRecyclerview.apply {
                layoutManager=GridLayoutManager(requireContext(),2)
                adapter = GifListAdapter(it)
            }
        })
    }



}