package com.vanka.housecon

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFrag:Fragment(R.layout.home_activity) {
    private lateinit var choise: String
    private lateinit var list: ArrayList<HomeDataModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_activity, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.rv_home)
        var ploat_choise = view.findViewById<Spinner>(R.id.sp_ploat)
        var bedRoom_choice = view.findViewById<Spinner>(R.id.sp_bed)


        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.setHasFixedSize(true)

        ploat_choise.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent != null) {
                    choise = parent.getItemAtPosition(position).toString()
                    if (choise == "up to 1000sqft") {
                        getUserData()
                    } else if (choise == "1000 to 2000 sqft") {
                        getUserData1()
                    } else if (choise == "2000 to 3000sqft") {
                     getUserData2()
                    }else{
                        getUserData3()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }




        return view
    }

    private fun getUserData() {

        FirebaseDatabase.getInstance().getReference("up to 1000sqft")
            .addValueEventListener(object : ValueEventListener {
                @SuppressLint("NotifyDataSetChanged")
                override fun onDataChange(snapshot: DataSnapshot) {
                    list = ArrayList<HomeDataModel>()
                    for (data in snapshot.children) if (snapshot.exists()) {
                        var dataget = data.getValue(HomeDataModel::class.java)

                        list.add(dataget!!)


                    }

                        view!!.findViewById<RecyclerView>(R.id.rv_home).adapter =
                            HomeViewAdapter(requireContext(), list)
                        HomeViewAdapter(requireContext(), list).notifyDataSetChanged()
                        view!!.findViewById<ProgressBar>(R.id.homeload).visibility = View.GONE


                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), "this", Toast.LENGTH_SHORT).show()
                }

            })


    }

    private fun getUserData1() {

        FirebaseDatabase.getInstance().getReference("1000 to 2000 sqft")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    view!!.findViewById<ProgressBar>(R.id.homeload).visibility = View.GONE
                    list = ArrayList<HomeDataModel>()
                    for (data in snapshot.children) {
                        if (snapshot.exists()) {
                            var dataget = data.getValue(HomeDataModel::class.java)

                            list.add(dataget!!)
                        }
                    }
                    view!!.findViewById<RecyclerView>(R.id.rv_home).adapter =
                        HomeViewAdapter(requireContext(),list)

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), "this", Toast.LENGTH_SHORT).show()
                }

            })


    }

    private fun getUserData2() {

        FirebaseDatabase.getInstance().getReference("2000 to 3000sqft")
            .addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    view!!.findViewById<ProgressBar>(R.id.homeload).visibility = View.GONE
                    list = ArrayList<HomeDataModel>()
                    for (data in snapshot.children) {
                        if (snapshot.exists()) {
                            var dataget = data.getValue(HomeDataModel::class.java)

                            list.add(dataget!!)

                        }
                    }
                    view!!.findViewById<RecyclerView>(R.id.rv_home).adapter =
                        HomeViewAdapter(requireContext(),list)

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), "this", Toast.LENGTH_SHORT).show()
                }

            })

    }
    private fun getUserData3() {

        FirebaseDatabase.getInstance().getReference("3000 sqft and above")
            .addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    view!!.findViewById<ProgressBar>(R.id.homeload).visibility = View.GONE
                    list = ArrayList<HomeDataModel>()
                    for (data in snapshot.children) {
                        if (snapshot.exists()) {
                            var dataget = data.getValue(HomeDataModel::class.java)

                            list.add(dataget!!)


                        }
                    }
                    view!!.findViewById<RecyclerView>(R.id.rv_home).adapter =
                        HomeViewAdapter(requireContext(),list)

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), "this", Toast.LENGTH_SHORT).show()
                }

            })

    }
}