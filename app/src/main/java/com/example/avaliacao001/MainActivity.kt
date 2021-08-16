package com.example.avaliacao001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.avaliacao001.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        alternateFragment(MainFragment())
    }

    fun alternateFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }

    fun activityDetalhes(dogsImages: String) {
        Intent(this, DetalhesActivity::class.java).apply{
            putExtra("data_dogs", dogsImages)
            startActivity(this)
        }
    }

}