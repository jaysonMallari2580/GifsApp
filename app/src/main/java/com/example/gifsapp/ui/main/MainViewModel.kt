package com.example.gifsapp.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gifsapp.ui.main.data.models.Category
import com.example.gifsapp.ui.main.data.models.DataDTO
import com.example.gifsapp.ui.main.data.models.GifDTO
import com.example.gifsapp.ui.main.data.repositories.GiphyRepo
import kotlinx.coroutines.*


class MainViewModel : ViewModel() {

    var _currentImageUrl = MutableLiveData<String>()
    val currenImageUrl get() =_currentImageUrl

    private val giphyRepo : GiphyRepo by lazy {
        GiphyRepo()
    }

    private var _searchList = MutableLiveData<List<GifDTO>>()
    val searchList get() =_searchList

    private var _giphyList = MutableLiveData<List<GifDTO>>()
    val giphyList get() = _giphyList

    private var _categoryList = ArrayList<Category>()
    val categoryList get() = _categoryList
    val listOfCategory = listOf<String>(
        "Trending",
        "Artist",
        "Clips",
        "Stories",
        "Stickers",
        "Emoji",
        "Text",
        "Reactions",
        "Memes",
        "Cats",
        "Dogs"
    )


    init {
        listOfCategory.forEach{
            _categoryList.add(Category(it))
        }
        getGiphy()
        println("List in MVM "+_giphyList)
    }


    fun getGiphy() = viewModelScope.launch(Dispatchers.IO) {
        try{
            val giphyListDeffered = async { giphyRepo.getGiphy().listOfGif }
            _giphyList.postValue(giphyListDeffered.await())

        }catch (e:Exception){
            Log.d("DID NOT WORK",e.message.toString())
        }
    }

    fun getSearchGiphy(title:String) = viewModelScope.launch(Dispatchers.IO) {
        try{
            val searchListDeffered =  async {giphyRepo.getSearchGiphy(title).searchList}
            _searchList.postValue(searchListDeffered.await())
        }catch (e: java.lang.Exception){
            Log.d("SEARCH list NOT working", e.message.toString())
        }
    }

}