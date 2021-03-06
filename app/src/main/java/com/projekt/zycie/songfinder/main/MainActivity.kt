package com.projekt.zycie.songfinder.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.projekt.zycie.songfinder.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
        presenter.test()
    }

    override fun test(s: String) {
        textview.text = s
    }
}
