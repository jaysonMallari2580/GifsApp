package com.example.gifsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gifsapp.databinding.MainActivityBinding
import com.example.gifsapp.ui.main.MainFragment
import com.example.gifsapp.ui.main.MainViewModel

class MainActivity : AppCompatActivity(){

    lateinit var binding:MainActivityBinding
    lateinit var viewModel: MainViewModel
    var listOfSearch = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(view)

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

            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listOfSearch)
            binding.searchAutocomple.setAdapter(adapter)
        })


        //Fragment call
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }*/
}