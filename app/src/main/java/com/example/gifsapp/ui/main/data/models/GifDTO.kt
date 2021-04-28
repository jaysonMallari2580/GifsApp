package com.example.gifsapp.ui.main.data.models

import com.google.gson.annotations.SerializedName

data class GifDTO(

    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("username")
    val userName: String,

    @SerializedName("images")
    val images : ImagesDTO
    )