package com.projekt.zycie.songfinder.main

import com.projekt.zycie.songfinder.base.BasePresenter

class MainPresenter : BasePresenter<MainView>() {
    fun test() {
        view?.test("asd")
    }
}