package com.example.avaliacao001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.avaliacao001.model.DogsImages
import com.example.avaliacao001.ui.main.DetalhesFragment
import com.example.avaliacao001.ui.main.MainFragment

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val dataDogs = intent.getStringExtra("data_dogs") as String

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_detalhes, DetalhesFragment.newInstance(dataDogs))
            .commitNow()

        findViewById<Button>(R.id.buttonBack).setOnClickListener {
            backScreen()
        }
    }

    fun backScreen() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
        }
    }

}