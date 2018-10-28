package com.projekt.zycie.songfinder.main

import android.annotation.SuppressLint
import com.projekt.zycie.songfinder.base.BasePresenter
import com.projekt.zycie.songfinder.utils.SchedulersProvider

class MainPresenter(
    private val mainUseCase: MainUseCase,
    private val schedulersProvider: SchedulersProvider
) : BasePresenter<MainView>() {

    fun onStart(mainView: MainView) {
        attachView(mainView)
    }

    fun onStop() {
        detachView()
    }

    @SuppressLint("CheckResult")
    fun test() {
        mainUseCase.getResponse("eldo")
            .subscribeOn(schedulersProvider.backgroundThread())
            .observeOn(schedulersProvider.mainThread())
            .subscribe(
                {
                    view?.test(it.resultCount.toString())
                },
                {
                    view?.test(it.toString())
                }
            )
    }
}