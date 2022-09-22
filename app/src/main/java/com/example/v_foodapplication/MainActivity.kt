package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val til_email = findViewById<TextInputLayout>(R.id.til_email)
        val til_password = findViewById<TextInputLayout>(R.id.til_password)
        val btn_register = findViewById<Button>(R.id.btn_register)
        val btn_login = findViewById<Button>(R.id.btn_login)

        btn_register.setOnClickListener {
            val intent = Intent(this@MainActivity,user_register::class.java)
            startActivity(intent)
        }
        btn_login.setOnClickListener {
            val intent = Intent(this@MainActivity,category::class.java)
            startActivity(intent)
        }
    }
}