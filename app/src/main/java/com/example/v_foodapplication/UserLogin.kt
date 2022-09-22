package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        //val til_email = findViewById<TextInputLayout>(R.id.til_email)
        //val til_password = findViewById<TextInputLayout>(R.id.til_password)
        val btn_register = findViewById<Button>(R.id.btn_register)
        val btn_login = findViewById<Button>(R.id.btn_login)

        btn_register.setOnClickListener {
            val intent = Intent(this@UserLogin,UserRegister::class.java)
            startActivity(intent)
        }
        btn_login.setOnClickListener {
            val intent = Intent(this@UserLogin,Category::class.java)
            startActivity(intent)
        }
    }
}