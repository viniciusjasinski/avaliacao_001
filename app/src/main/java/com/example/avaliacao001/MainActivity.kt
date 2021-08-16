package com.example.avaliacao001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avaliacao001.model.DogsImages
import com.example.avaliacao001.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    fun activityDetalhes(dogsImages: DogsImages) {
        Intent(this, DetalhesActivity::class.java).apply{
            putExtra("data_dogs", dogsImages)
            startActivity(this)
        }
    }

}