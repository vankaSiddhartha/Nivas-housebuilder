package com.vanka.housecon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils.replace
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainWorkActivity : AppCompatActivity() {
    var INTE:Int = 0
    var Cart:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_work)
        supportActionBar?.hide()
        val size = intent.getStringExtra("size")
        var HomeFrag = HomeFrag()
        var CartFrag = CartFrag()
        var InteriorDesignFrag = InteriorDesignFrag()
        var ProfileFrag = ProfileFrag()
        var LoadFrag = loadFrag()


        setFragmentForMain(HomeFrag)

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {


                        setFragmentForMain(HomeFrag)



                }


                R.id.intdesign -> {


                    if(INTE==0){
                        Handler(Looper.myLooper()!!).postDelayed({
                            setFragmentForMain(InteriorDesignFrag)
                        },1000)
                    }else{
                        setFragmentForMain(InteriorDesignFrag)
                    }
                   INTE++





                }


                R.id.cart ->{
                          if(Cart==0){
                              Handler(Looper.myLooper()!!).postDelayed({
                                  setFragmentForMain(CartFrag)
                              },1000)
                          }else{
                              setFragmentForMain(CartFrag)
                          }
                    Cart++



                    }







                R.id.profile -> setFragmentForMain(ProfileFrag)
            }
            true

        }


    }

    private fun setFragmentForMain(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.cont, fragment).setTransition(TRANSIT_FRAGMENT_OPEN)
                commit()
        }

    }
}

