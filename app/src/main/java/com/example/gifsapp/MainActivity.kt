package com.example.gifsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.gifsapp.databinding.MainActivityBinding
import com.example.gifsapp.ui.main.MainFragment
import com.example.gifsapp.ui.main.MainViewModel

class MainActivity : AppCompatActivity(){

    lateinit var binding:MainActivityBinding
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(R.layout.main_activity)


        //Navigation
        Navigation.findNavController(this,R.id.nav_host_fragment_container).setGraph(R.navigation.nav_graph)


    }

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }*/
}