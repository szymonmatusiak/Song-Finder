package com.projekt.zycie.songfinder.utils

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulersProvider {
    fun mainThread() = AndroidSchedulers.mainThread()!!
    fun backgroundThread() = Schedulers.io()
}
