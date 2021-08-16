package com.example.avaliacao001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avaliacao001.ui.main.DetalhesFragment
import com.example.avaliacao001.ui.main.MainFragment

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_detalhes, DetalhesFragment())
            .commitNow()
    }
}