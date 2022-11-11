package com.vanka.housecon

import CartAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class CartFrag:Fragment(R.layout.cart) {
    private lateinit var list: ArrayList<CartDataClass>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.cart, container, false)
        var rv = view.findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.setHasFixedSize(true)
        var UID = FirebaseAuth.getInstance().currentUser!!.uid

            getUserData(UID)



        return view
    }
    private fun getUserData(UID: String) {

       FirebaseDatabase.getInstance().getReference("CartData")
           .addValueEventListener(object : ValueEventListener{
               override fun onDataChange(snapshot: DataSnapshot) {

                       view!!.findViewById<ProgressBar>(R.id.load).visibility = View.GONE


                   list = ArrayList<CartDataClass>()
                       for(data in snapshot.children){
                           if(snapshot.exists()){
                           var dataCom = data.getValue(CartDataClass::class.java)
                               if(dataCom!!.ID.equals(UID)) {
                                   list.add(dataCom)
                               }

                       }

                   }

                       view!!.findViewById<RecyclerView>(R.id.rv).adapter = CartAdapter(requireContext(),list)



               }

               override fun onCancelled(error: DatabaseError) {

               }

           })


    }
}