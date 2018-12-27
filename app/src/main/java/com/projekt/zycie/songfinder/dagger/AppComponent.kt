package com.projekt.zycie.songfinder.dagger

import com.projekt.zycie.songfinder.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    PresenterModule::class])
interface AppComponent {
    fun inject(target: MainActivity)
}