package com.example.ex2ques1



import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Submission_Details : AppCompatActivity() {

    companion object {
        private const val CAMERA_PERMISSION_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission_details)

        val intent = intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")


        //textview
        val details = findViewById<TextView>(R.id.textView3)
        //setText
        details.text = "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone

        var btn = findViewById<View>(R.id.button2) as Button
        var webpage = findViewById<View>(R.id.url) as EditText

        var url: String = webpage.text.toString();

        btn!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        var btn2 = findViewById<View>(R.id.button3) as Button



        fun checkPermission(permission: String,
                            requestCode: Int) {
            if (ContextCompat.checkSelfPermission(this@Submission_Details, permission) == PackageManager.PERMISSION_DENIED) {

                // Requesting the permission
                ActivityCompat.requestPermissions(this@Submission_Details, arrayOf(permission), requestCode)
            } else {
                Toast.makeText(this@Submission_Details, "Permission already granted", Toast.LENGTH_SHORT).show()
            }
        }

        btn2!!.setOnClickListener {
            checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
        }

        fun onRequestPermissionsResult(requestCode: Int,
                                       permissions: Array<String>,
                                       grantResults: IntArray) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode == CAMERA_PERMISSION_CODE) {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this@Submission_Details, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@Submission_Details, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
            }
    }

}