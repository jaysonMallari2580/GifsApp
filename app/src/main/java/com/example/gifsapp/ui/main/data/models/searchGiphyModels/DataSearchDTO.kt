package com.example.gifsapp.ui.main.data.models.searchGiphyModels

import com.example.gifsapp.ui.main.data.models.GifDTO
import com.google.gson.annotations.SerializedName

data class DataSearchDTO (

    @SerializedName("data")
    val searchList : ArrayList<GifDTO>
)