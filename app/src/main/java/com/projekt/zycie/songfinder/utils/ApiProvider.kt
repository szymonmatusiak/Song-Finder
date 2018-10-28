package com.projekt.zycie.songfinder.utils

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    private const val API_BASE_URL = "https://itunes.apple.com/"

    private val retrofit: Retrofit
    private val service: ApiService

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        service = retrofit.create(ApiService::class.java)
    }

    fun getResponse(name: String) = service.getResponse(name)

}