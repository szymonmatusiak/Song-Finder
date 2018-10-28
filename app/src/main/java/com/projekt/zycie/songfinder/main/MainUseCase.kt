package com.projekt.zycie.songfinder.main

import com.projekt.zycie.songfinder.models.SongListITunes
import com.projekt.zycie.songfinder.utils.ApiProvider
import io.reactivex.Single

class MainUseCase(private val apiProvider: ApiProvider) {
    fun getResponse(name: String): Single<SongListITunes> {
        return apiProvider.getResponse(name)
    }
}