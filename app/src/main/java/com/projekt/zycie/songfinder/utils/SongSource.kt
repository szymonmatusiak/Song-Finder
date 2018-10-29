package com.projekt.zycie.songfinder.utils

import android.support.annotation.ColorRes
import com.projekt.zycie.songfinder.R

enum class SongSource(val source: String, @ColorRes val color: Int) {
    LOCAL("Local", R.color.colorAccent),
    ITUNES("iTunes", R.color.colorPrimary)
}