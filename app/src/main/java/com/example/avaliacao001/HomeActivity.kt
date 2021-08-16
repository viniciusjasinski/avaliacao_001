package com.example.avaliacao001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.buttonHomePass).setOnClickListener {
            Intent(this, MainActivity::class.java).apply{
                startActivity(this)
            }
        }
    }
}