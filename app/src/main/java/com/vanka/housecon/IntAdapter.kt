package com.vanka.housecon


import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class IntAdapter(var context: Context,private val userList : ArrayList<DataBrpo>) : RecyclerView.Adapter<IntAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.interior_list,
            parent, false
        )
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]
        holder.name.text = currentitem.ProductName
        Glide.with(context).load(currentitem.link).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
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
        }).into(holder.intimg)
        holder.itemView.setOnClickListener {
            var intent = Intent(context,IntActionAct::class.java)
            intent.putExtra("name",currentitem.ProductName)
            intent.putExtra("dis",currentitem.dis)
            intent.putExtra("link",currentitem.link)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById<TextView>(R.id.name)
        val intimg = itemView.findViewById<ImageView>(R.id.intimage)

    }
}

