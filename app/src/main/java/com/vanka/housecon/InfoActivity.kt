package com.vanka.housecon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class  InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val skip = findViewById<TextView>(R.id.skip1)
        val btn = findViewById<Button>(R.id.Next1)
        btn.setOnClickListener {
            startActivity(Intent(this,InfoActivity2::class.java))
        }
        skip.setOnClickListener {
            startActivity(Intent(this,createAccount::class.java))
        }

    }
}