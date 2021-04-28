package com.example.gifsapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

data class DataDTO (

    @SerializedName("data")
    val listOfGif : ArrayList<GifDTO>
        )