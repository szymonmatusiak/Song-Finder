package com.projekt.zycie.songfinder.main

import android.annotation.SuppressLint
import com.projekt.zycie.songfinder.base.BasePresenter
import com.projekt.zycie.songfinder.models.Song
import com.projekt.zycie.songfinder.utils.SchedulersProvider

class MainPresenter(
    private val mainUseCase: GetSongsUseCase,
    private val schedulersProvider: SchedulersProvider
) : BasePresenter<MainView>() {

    fun onStart(mainView: MainView) {
        attachView(mainView)
    }

    fun onStop() {
        detachView()
    }

    @SuppressLint("CheckResult")
    fun getSongsByArtist(artist: String) {
        mainUseCase.getSongs(artist)
            .subscribeOn(schedulersProvider.backgroundThread())
            .observeOn(schedulersProvider.mainThread())
            .subscribe(
                {
                    view?.setSongs(it)
                },
                {
                    view?.showError(it.toString())
                }
            )
    }

    fun openDetailsActivity(song: Song) {
        view?.openDetailsActivity(song)
    }
}