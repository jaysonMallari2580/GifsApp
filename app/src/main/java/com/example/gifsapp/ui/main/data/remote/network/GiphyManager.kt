package com.example.gifsapp.ui.main.data.remote.network

import com.example.gifsapp.ui.main.data.models.DataDTO
import com.example.gifsapp.ui.main.data.models.GifDTO
import com.example.gifsapp.ui.main.data.models.searchGiphyModels.DataSearchDTO
import retrofit2.http.GET
import retrofit2.http.Query

class GiphyManager {

    private val service : GiphyService
    private val retrofit = RetrofitService.provideRetrofitService()

    companion object{
        private val key ="kAhX2Y0GPpK9igTCBavMtyPxICyBdiJE"
        private val limit = "25"
        private val rating ="g"
    }

    init {
        service = retrofit.create(GiphyService::class.java)
    }

    suspend fun getGiphy() = service.getGiphy()
    suspend fun getSearchGiphy(q:String = "test") = service.getSearchGiphy(q)

    interface GiphyService {
        //api_key=kAhX2Y0GPpK9igTCBavMtyPxICyBdiJE&limit=25&rating=g
        @GET("v1/gifs/trending")
        suspend fun getGiphy(
            @Query("api_key")key:String =GiphyManager.key,
            @Query("limit")limit:String = GiphyManager.limit,
            @Query("rating")rating:String = GiphyManager.rating):DataDTO

        //api_key=kAhX2Y0GPpK9igTCBavMtyPxICyBdiJE&q=test&limit=25&offset=0&rating=g&lang=en
        @GET("v1/gifs/search")
        suspend fun getSearchGiphy(
            @Query("q")q:String,
            @Query("api_key")key:String =GiphyManager.key,
            @Query("limit")limit:String ="25",
            @Query("offset")offset:String = "0",
            @Query("rating")rating:String = GiphyManager.rating,
            @Query("lang")lang:String = "en"
        ):DataSearchDTO
    }
}


