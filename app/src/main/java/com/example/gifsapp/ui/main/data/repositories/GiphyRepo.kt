package com.example.gifsapp.ui.main.data.repositories

import android.icu.text.CaseMap
import androidx.lifecycle.MutableLiveData
import com.example.gifsapp.ui.main.data.models.DataDTO
import com.example.gifsapp.ui.main.data.models.GifDTO
import com.example.gifsapp.ui.main.data.models.searchGiphyModels.DataSearchDTO
import com.example.gifsapp.ui.main.data.remote.network.GiphyManager

class GiphyRepo {

    suspend fun getGiphy():DataDTO{
        return GiphyManager().getGiphy()
    }

    suspend fun getSearchGiphy(title: String):DataSearchDTO{
        return GiphyManager().getSearchGiphy(title)
    }
}