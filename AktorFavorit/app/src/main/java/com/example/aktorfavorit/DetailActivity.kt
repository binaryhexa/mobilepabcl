package com.example.aktorfavorit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aktorfavorit.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {
    private val binding : ActivityDetailBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setData()
    }

    private fun setData() {
        binding.apply{
            val actors = intent.getParcelableExtra<Actors>(EXTRA_DETAIL)

            tvActorName.text = actors?.name
            tvBirth.text = actors?.birth
            tvMovies.text = actors?.movies
            tvDetails.text = actors?.detail


            Glide.with(this@DetailActivity)
                .load(actors?.photo)
                .apply(RequestOptions())
                .into(avActor)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        const val EXTRA_DETAIL = "extra_detail"
    }

}