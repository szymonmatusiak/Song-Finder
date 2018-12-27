package com.projekt.zycie.songfinder.main

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.projekt.zycie.songfinder.models.Song

class SongsAdapter(
    private val songs: List<Song>,
    private val songClickListener: SongClickListener) : RecyclerView.Adapter<SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SongViewHolder.createViewHolder(parent)

    override fun getItemCount() = songs.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.setData(songs[position], songClickListener)
    }

}