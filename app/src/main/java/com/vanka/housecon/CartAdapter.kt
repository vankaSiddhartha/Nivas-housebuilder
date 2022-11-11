
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
import com.vanka.housecon.ActionAct
import com.vanka.housecon.CartDataClass
import com.vanka.housecon.R

class CartAdapter(var context: Context,private val userList : ArrayList<CartDataClass>) : RecyclerView.Adapter<CartAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cart_model,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.ploatArea.text = currentitem.ploatArea
        holder.bed.text = currentitem.Bedrooms
        holder.dim.text = currentitem.Dimention
        holder.fl.text = currentitem.Floors
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
        }).into(holder.img)
        holder.itemView.setOnClickListener {
            var intent = Intent(context,ActionAct::class.java)
            intent.putExtra("ProductName",currentitem.productName)
            intent.putExtra("Dis",currentitem.dis)
            intent.putExtra("ploatSize",currentitem.ploatArea)
            intent.putExtra("floors",currentitem.Floors)
            intent.putExtra("Dim",currentitem.Dimention)
            intent.putExtra("bedroom",currentitem.Bedrooms)
            intent.putExtra("link",currentitem.link)
            intent.putExtra("size",currentitem.Size)
            intent.putExtra("ID",currentitem.ID)

            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val ploatArea : TextView = itemView.findViewById(R.id.pt_ar)
        val dim: TextView = itemView.findViewById(R.id.dim)
        val fl : TextView = itemView.findViewById(R.id.fl)
        val bed :TextView = itemView.findViewById(R.id.bed)
        var img :ImageView = itemView.findViewById(R.id.imageView)


    }

}