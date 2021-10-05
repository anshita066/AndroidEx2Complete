package com.example.ex2ques1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var btn: Button? = null
    var username: EditText? = null
    var email: EditText? = null
    var password: EditText? = null
    var phone: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById<View>(R.id.button) as Button
        username = findViewById<View>(R.id.user) as EditText
        email = findViewById<View>(R.id.usermail) as EditText
        password = findViewById<View>(R.id.userpass) as EditText
        phone = findViewById<View>(R.id.userphone) as EditText
        btn!!.setOnClickListener {
            val intent = Intent(this@MainActivity,Submission_Details::class.java).apply {
                putExtra("name", username!!.text.toString() )
                putExtra("email",email!!.text.toString() )
                putExtra("phone",phone!!.text.toString() )
            }
            startActivity(intent)
            }
        }
    }


