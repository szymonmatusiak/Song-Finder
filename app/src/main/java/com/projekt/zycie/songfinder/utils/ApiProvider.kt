package com.projekt.zycie.songfinder.utils

import javax.inject.Inject

class ApiProvider @Inject constructor(private val service: ApiService) {
    fun getSongs(name: String) = service.getResponse(name)
}