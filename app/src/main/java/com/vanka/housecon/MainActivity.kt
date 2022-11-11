package com.vanka.housecon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this,InfoActivity::class.java))
            if(FirebaseAuth.getInstance().currentUser!=null){
                startActivity(Intent(this,MainWorkActivity::class.java))
            }

            finish()
        },1000)
    }
}