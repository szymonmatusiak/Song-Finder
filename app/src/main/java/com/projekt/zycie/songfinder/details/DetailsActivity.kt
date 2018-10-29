package com.projekt.zycie.songfinder.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.projekt.zycie.songfinder.R
import com.projekt.zycie.songfinder.models.Song
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val parcelable = intent?.extras?.getParcelable<Song>(DetailsActivity.SONG.toString())!!
        song_text.text = parcelable.toString()
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
