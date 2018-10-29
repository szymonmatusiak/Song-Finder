package com.projekt.zycie.songfinder.models

import android.os.Parcelable
import com.projekt.zycie.songfinder.utils.SongSource
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Song(
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val releaseDate: String,
    val primaryGenreName: String,
    val artworkUrl100: String,
    var songSource: SongSource
) : Parcelable