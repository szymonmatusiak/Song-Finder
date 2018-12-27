package com.projekt.zycie.songfinder.dagger

import com.projekt.zycie.songfinder.utils.ApiProvider
import com.projekt.zycie.songfinder.utils.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {
    companion object {
        private const val API_URL = "API_URL"
        private const val OK = "OK"
        private const val API_BASE_URL = "https://itunes.apple.com/"
    }


    @Provides
    @Singleton
    fun provideLoggingInterceptor() =  HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)



    @Provides
    @Singleton
    @Named(OK)
    fun provideHttpClient(loggingInterceptor : HttpLoggingInterceptor) = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(@Named(OK)okHttpClient: OkHttpClient)=
        Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit)= retrofit.create(ApiService::class.java)

}