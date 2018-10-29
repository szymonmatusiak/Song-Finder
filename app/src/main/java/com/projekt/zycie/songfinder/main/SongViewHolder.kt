package com.projekt.zycie.songfinder.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.projekt.zycie.songfinder.R
import com.projekt.zycie.songfinder.models.Song
import com.projekt.zycie.songfinder.utils.SongSource
import kotterknife.bindView

class SongViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private val artistName: TextView by bindView(R.id.artist_name)
    private val trackName: TextView by bindView(R.id.track_name)

    companion object {
        fun createViewHolder(viewGroup: ViewGroup): SongViewHolder {
            val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.song_list_element, viewGroup, false)
            return SongViewHolder(v)
        }
    }

    fun setData(song: Song, songClickListener: SongClickListener) {
        artistName.text = song.artistName
        trackName.text = song.songSource.source//.toString()//song.songSource.value
    }
}
