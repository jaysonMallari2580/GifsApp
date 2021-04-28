package com.example.gifsapp.ui.main

import android.R
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.gifsapp.databinding.MainFragmentBinding
import com.example.gifsapp.ui.main.adapter.CategoryListAdapter
import com.example.gifsapp.ui.main.adapter.GifListAdapter

class MainFragment : Fragment() {

    lateinit var binding: MainFragmentBinding
    var listOfSearch = ArrayList<String>()


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

        //autoComplete Search
        binding.searchAutocomple.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                viewModel.getSearchGiphy(s.toString())
            }
        })

        viewModel.searchList.observe(this, Observer {

            it.forEach{
                listOfSearch.add(it.title)
            }

            val adapter = ArrayAdapter(this, R.layout.simple_list_item_1,listOfSearch)
            binding.searchAutocomple.setAdapter(adapter)
        })


        //Fragment call
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(com.example.gifsapp.R.id.container, MainFragment.newInstance())
                .commitNow()
        }

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