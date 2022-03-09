package com.example.pinterest.retrofit

import com.example.pinterest.retrofit.service.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {
    val IS_TESTER = true
    val SERVER_DEVELOPMENT ="https://api.unsplash.com/"
    val SERVER_PRODUCTION = "https://api.unsplash.com/"
    val retrofit = Retrofit.Builder().baseUrl(server()).addConverterFactory(GsonConverterFactory.create()).build()

    fun server(): String{
        if (IS_TESTER) return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }

    val photoService:RetrofitService = retrofit.create(RetrofitService::class.java)
}