package com.vanka.housecon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class createAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        supportActionBar?.hide()
        var name = findViewById<EditText>(R.id.name)
        var email = findViewById<EditText>(R.id.Email)
        var pass = findViewById<EditText>(R.id.password)
        var passRetype = findViewById<EditText>(R.id.passwordRetype)
        val btn = findViewById<Button>(R.id.signup)
        val textIntent = findViewById<TextView>(R.id.textin)
        findViewById<ProgressBar>(R.id.progressBar).visibility =View.GONE
        textIntent.setOnClickListener {
            startActivity(Intent(this,LoginAct::class.java))
        }
        btn.setOnClickListener {

            sendData(name, email, pass, passRetype)
        }


    }

    private fun sendData(
        name: EditText?,
        email: EditText?,
        pass: EditText?,
        passRetype: EditText?
    ) {
        var naam = name!!.text.toString().trim()
        var mail = email!!.text.toString().trim()
        var pword = pass!!.text.toString().trim()
        var pwordR = passRetype!!.text.toString().trim()

            if (naam.isNotEmpty() && mail.isNotEmpty() && pword.isNotEmpty() && pword.isNotEmpty()) {
                if (pword.equals(pwordR)) {
                    findViewById<ProgressBar>(R.id.progressBar).visibility =View.VISIBLE

                Firebase.auth.createUserWithEmailAndPassword(mail, pwordR).addOnSuccessListener {

                    startActivity(Intent(this,LoginAct::class.java))
                    findViewById<ProgressBar>(R.id.progressBar).visibility =View.GONE
                    Toast.makeText(this, "successfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                }
            }else {
            Toast.makeText(this, "Password is not mathching retype again!!", Toast.LENGTH_SHORT).show()
        }
    }else{
                Toast.makeText(this, "Empty fills not allowed!!", Toast.LENGTH_SHORT).show()

            }    }
}