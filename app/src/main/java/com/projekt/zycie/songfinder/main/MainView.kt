package com.projekt.zycie.songfinder.main

import com.projekt.zycie.songfinder.base.IBaseView
import com.projekt.zycie.songfinder.models.Song

interface MainView : IBaseView {
    fun setSongs(songs: List<Song>)
    fun showError(error: String)
    fun openDetailsActivity(song: Song)
}