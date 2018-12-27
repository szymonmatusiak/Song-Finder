package com.projekt.zycie.songfinder.dagger

import com.projekt.zycie.songfinder.main.GetSongsUseCase
import com.projekt.zycie.songfinder.main.MainPresenter
import com.projekt.zycie.songfinder.utils.SchedulersProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideMainPresenter(mainUseCase: GetSongsUseCase): MainPresenter = MainPresenter(mainUseCase,SchedulersProvider())
}