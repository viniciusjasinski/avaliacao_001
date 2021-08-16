package com.example.avaliacao001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.avaliacao001.ui.main.DetalhesFragment
import com.example.avaliacao001.ui.main.MainFragment

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_detalhes, DetalhesFragment())
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