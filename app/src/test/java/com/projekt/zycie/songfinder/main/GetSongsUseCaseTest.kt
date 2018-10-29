package com.projekt.zycie.songfinder.main

import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.projekt.zycie.songfinder.models.Song
import com.projekt.zycie.songfinder.models.SongListITunes
import com.projekt.zycie.songfinder.utils.ApiProvider
import com.projekt.zycie.songfinder.utils.SongSource
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GetSongsUseCaseTest {
    private lateinit var apiProvider: ApiProvider
    private lateinit var getSongsUseCase: GetSongsUseCase
    private lateinit var song: Song
    @Before
    fun setUp() {
        apiProvider = mock()
        getSongsUseCase = GetSongsUseCase(apiProvider)
        song = Song("eldo", "api", "api", "api", "api", "", SongSource.LOCAL)

    }

    @Test
    fun `getSongs returns empty list`() {
        whenever(apiProvider.getSongs("test")).thenReturn(Single.just(SongListITunes(0, emptyList())))
        val test = getSongsUseCase.getSongs("test").test()
        test.assertValue(emptyList())
    }

    @Test
    fun `getSongs returns one element from localList`() {
        whenever(apiProvider.getSongs("eldo")).thenReturn(Single.just(SongListITunes(0, emptyList())))
        val test = getSongsUseCase.getSongs("eldo").map { it.size }.test()
        test.assertValue(1)
    }

    @Test
    fun `getSongs returns combined from api and local`() {
        whenever(apiProvider.getSongs("eldo")).thenReturn(Single.just(SongListITunes(0, listOf(song))))
        val test = getSongsUseCase.getSongs("eldo").map { it.size }.test()
        test.assertValue(2)
    }

    @Test
    fun `server return error`() {
        whenever(apiProvider.getSongs("eldo")).doAnswer { Single.error(Throwable()) }
        val test = getSongsUseCase.getSongs("eldo").map { it.size }.test()
        test.assertValue(2)
    }

    @Test
    fun getLocalSongs() {
    }
}