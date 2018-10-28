package com.projekt.zycie.songfinder.models

data class SongListITunes(
    val resultCount: Int,
    val results: List<Result>
)