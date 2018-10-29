package com.projekt.zycie.songfinder.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.projekt.zycie.songfinder.R
import com.projekt.zycie.songfinder.models.Song
import com.squareup.picasso.Picasso
import kotterknife.bindView


class DetailsActivity : AppCompatActivity() {
    private val artwork: ImageView by bindView(R.id.artwork)
    private val songTitle: TextView by bindView(R.id.song_title)
    private val artistName: TextView by bindView(R.id.artist_name)
    private val collectionName: TextView by bindView(R.id.collection_name)
    private val releaseDate: TextView by bindView(R.id.release_date)
    private val primaryGenre: TextView by bindView(R.id.primary_genre)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val song = intent?.extras?.getParcelable<Song>(DetailsActivity.SONG.toString())!!
        setView(song)
    }

    private fun setView(song: Song) {
        if (song.artworkUrl100.isNotEmpty()) {
            Picasso.get()
                .load(song.artworkUrl100)
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .centerInside()
                .error(R.drawable.ic_launcher_background)
                .into(artwork)
        }
        songTitle.text = song.trackName
        artistName.text = song.artistName
        collectionName.text = song.collectionName
        releaseDate.text = song.releaseDate.substringBefore("T")
        primaryGenre.text = song.primaryGenreName
    }


    companion object {
        const val SONG = 20
        fun getIntent(context: Context, song: Song): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable(DetailsActivity.SONG.toString(), song)
            intent.putExtras(bundle)
            return intent
        }
    }
}
