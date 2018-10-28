package com.projekt.zycie.songfinder.base

import java.lang.ref.WeakReference

abstract class BasePresenter<V : IBaseView> : IBasePresenter<V> {
    private var viewReference: WeakReference<V>? = null
    override fun attachView(view: V) {
        viewReference = WeakReference(view)
    }

    override fun detachView() {
        viewReference?.clear()
        viewReference = null
    }

    protected val view: V?
        get() = viewReference?.get()

    protected val isViewAttached: Boolean
        get() = viewReference?.get() != null
}