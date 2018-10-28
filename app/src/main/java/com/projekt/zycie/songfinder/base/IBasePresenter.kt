package com.projekt.zycie.songfinder.base

interface IBasePresenter<V : IBaseView> {
    fun attachView(view: V)
    fun detachView()
}