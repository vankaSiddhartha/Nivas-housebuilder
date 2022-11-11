package com.vanka.housecon

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class IntActionAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_int_action)
        supportActionBar?.hide()
        var getImg = intent.getStringExtra("link")
        var getDis = intent.getStringExtra("dis")
        var name = intent.getStringExtra("name")
        var i_name = findViewById<TextView>(R.id.in_name)
        var i_dis = findViewById<TextView>(R.id.indis)
        var img = findViewById<ImageView>(R.id.inimage)
        i_name.text = name
        i_dis.text = getDis
        i_dis.movementMethod = ScrollingMovementMethod()
        Glide.with(this).load(getImg).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                Toast.makeText(this@IntActionAct, "Click on me!!", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {

                return false
            }
        }).into(img)
    }
}