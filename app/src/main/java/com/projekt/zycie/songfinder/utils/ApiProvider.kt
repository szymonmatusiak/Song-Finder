package com.projekt.zycie.songfinder.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    private const val API_BASE_URL = "https://itunes.apple.com/"

    private val retrofit: Retrofit
    private val service: ApiService
    private val logging = HttpLoggingInterceptor()

    init {
        logging.level = HttpLoggingInterceptor.Level.BASIC

        var okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        service = retrofit.create(ApiService::class.java)
    }

    fun getResponse(name: String) = service.getResponse(name)

}