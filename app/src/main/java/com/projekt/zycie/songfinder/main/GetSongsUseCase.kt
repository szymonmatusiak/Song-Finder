package com.projekt.zycie.songfinder.main

import com.projekt.zycie.songfinder.models.Song
import com.projekt.zycie.songfinder.models.SongListITunes
import com.projekt.zycie.songfinder.utils.ApiProvider
import com.projekt.zycie.songfinder.utils.SongSource
import io.reactivex.Single
import io.reactivex.Single.zip
import io.reactivex.functions.BiFunction

class GetSongsUseCase(
    private val apiProvider: ApiProvider
) {

    fun getSongs(name: String): Single<List<Song>> {
        val songsApi = apiProvider
            .getSongs(name)
            .map { setSourceITunes(it).results }
            .onErrorResumeNext { Single.just(emptyList()) }
        val filterLocalSongs = getLocalSongs().filter { it.artistName.contains(name) }
        val single = Single.just(filterLocalSongs)
        return zip(
            songsApi,
            single,
            BiFunction { songsITunes, songsLocal ->
                val resultList = arrayListOf<Song>()
                resultList.addAll(songsITunes)
                resultList.addAll(songsLocal)
                return@BiFunction resultList
            })
    }

    private fun setSourceITunes(it: SongListITunes): SongListITunes {
        it.results.forEach { it.songSource = SongSource.ITUNES }
        return it
    }

    fun getLocalSongs() = listOf(
        Song("eldo", "local", "local", "local", "local", "", SongSource.LOCAL),
        Song("p", "local1", "local1", "local", "local", "", SongSource.LOCAL),
        Song("madonna", "local", "local", "local", "local", "", SongSource.LOCAL)
    )

}