package com.projekt.zycie.songfinder.main

import com.projekt.zycie.songfinder.utils.ApiProvider

class MainUseCase(private val apiProvider: ApiProvider) {
    fun getResponse(name: String) = apiProvider.getResponse(name)

}