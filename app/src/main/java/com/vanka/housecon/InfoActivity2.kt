package com.vanka.housecon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class InfoActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info2)
        val skip = findViewById<TextView>(R.id.skip2)
        val btn  = findViewById<Button>(R.id.Next2)
        btn.setOnClickListener {
            startActivity(Intent(this,createAccount::class.java))
        }
        skip.setOnClickListener {
            startActivity(Intent(this,createAccount::class.java))
        }
    }
}