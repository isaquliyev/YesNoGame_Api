package com.example.a3005_yesnogame.api

import retrofit2.Call
import retrofit2.http.GET
import com.example.a3005_yesnogame.model.Result

interface Api {
    @GET("api")
    fun getResult() : Call<Result>
}