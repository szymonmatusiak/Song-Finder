package com.projekt.zycie.songfinder.main

import com.projekt.zycie.songfinder.models.Song

interface SongClickListener {
    fun showSongDetalis(song: Song)
}
