package com.vanka.housecon

import CartAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class InteriorDesignFrag:Fragment(R.layout.interior_design) {
    private lateinit var list:ArrayList<DataBrpo>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.cart, container, false)
        view.findViewById<RecyclerView>(R.id.rv).layoutManager = LinearLayoutManager(requireContext())
        list = ArrayList()
        getIntDesList()
        view.findViewById<RecyclerView>(R.id.rv).adapter = IntAdapter(requireContext(),list)

        return view
    }

    private fun getIntDesList() {
       FirebaseDatabase.getInstance().getReference("IntDes")
           .addValueEventListener(object : ValueEventListener{
               override fun onDataChange(snapshot: DataSnapshot) {
                   list = ArrayList<DataBrpo>()
                   for(data in snapshot.children){
                       if (snapshot.exists()){

                           var getBro = data.getValue(DataBrpo::class.java)
                           list.add(getBro!!)
                       }

                   }

                       view!!.findViewById<RecyclerView>(R.id.rv).adapter = IntAdapter(requireContext(),list)
                       view!!.findViewById<ProgressBar>(R.id.load).visibility = View.GONE


               }

               override fun onCancelled(error: DatabaseError) {
                   TODO("Not yet implemented")
               }

           })
    }
}