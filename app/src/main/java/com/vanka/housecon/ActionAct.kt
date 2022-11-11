package com.vanka.housecon

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

data class DataPass(var size:String,var id:String)
class ActionAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)
         val productName = intent.getStringExtra("ProductName")
        val Dis = intent.getStringExtra("Dis")
        val  ploatSize = intent.getStringExtra("ploatSize")
        val floors = intent.getStringExtra("floors")
        val Dim = intent.getStringExtra("Dim")
        val bedroom = intent.getStringExtra("bedroom")
        val link = intent.getStringExtra("link")
        val img = findViewById<ImageView>(R.id.image)
        val pd_name = findViewById<TextView>(R.id.pd_name)
        val ploat = findViewById<TextView>(R.id.ploatSize)
        val bed = findViewById<TextView>(R.id.bedrooms)
        val floor = findViewById<TextView>(R.id.floors)
        val dims = findViewById<TextView>(R.id.dimn)
        var id = intent.getStringExtra("ID")
        var size = intent.getStringExtra("size")
        var favUp = findViewById<Button>(R.id.addFav)
        ploat.text = ploatSize
        bed.text = bedroom
        floor.text =floors
        dims.text=Dim

        pd_name.text = productName
        val dis = findViewById<TextView>(R.id.dis)
        dis.text =Dis
        dis.movementMethod = ScrollingMovementMethod()
        var data = CartDataClass(ploatSize,Dim,floors,bedroom,Dis,productName,link,FirebaseAuth.getInstance().currentUser!!.uid.toString(),size)
        favUp.setOnClickListener {

             upLoadCartData(data,id)


        }
        Glide.with(this).load(link).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                Toast.makeText(this@ActionAct, "Click on me!!", Toast.LENGTH_SHORT).show()
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

    private fun upLoadCartData(data: CartDataClass, id: String?) {
       val up = FirebaseDatabase.getInstance().getReference()
        up.child("CartData").child(id!!).setValue(data).addOnSuccessListener {
            Toast.makeText(this, "Sucessfull!!", Toast.LENGTH_SHORT).show()
        }
    }
}