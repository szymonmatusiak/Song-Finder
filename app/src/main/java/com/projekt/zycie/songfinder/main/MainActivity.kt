package com.projekt.zycie.songfinder.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.SearchView
import android.widget.Toast
import com.projekt.zycie.songfinder.R
import com.projekt.zycie.songfinder.models.Song
import com.projekt.zycie.songfinder.utils.ApiProvider
import com.projekt.zycie.songfinder.utils.SchedulersProvider
import kotterknife.bindView

class MainActivity : AppCompatActivity(), MainView, SongClickListener {
    private val searchView: SearchView by bindView(R.id.search)
    private val recyclerView: RecyclerView by bindView(R.id.recycler_view_songs)
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(GetSongsUseCase(ApiProvider), SchedulersProvider())
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.getSongsByArtist(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

    }

    override fun setSongs(songs: List<Song>) {
        viewManager = LinearLayoutManager(this)
        viewAdapter = SongsAdapter(songs!!, this)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG)
    }

}
