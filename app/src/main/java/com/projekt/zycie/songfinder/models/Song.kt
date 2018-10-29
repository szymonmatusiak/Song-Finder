package com.projekt.zycie.songfinder.models

import com.projekt.zycie.songfinder.utils.SongSource


data class Song(
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val collectionArtistName: String,
    val releaseDate: String,
    val primaryGenreName: String,
    var songSource: SongSource
)