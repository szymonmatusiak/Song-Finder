package com.projekt.zycie.songfinder.utils

import com.projekt.zycie.songfinder.models.SongListITunes
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun getResponse(@Query("term") name: String): Single<SongListITunes>
}