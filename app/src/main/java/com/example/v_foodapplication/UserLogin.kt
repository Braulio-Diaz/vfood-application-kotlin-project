package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class UserLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        //DECLARAMOS LAS VARIABLES Y LAS REFERENCIAMOS CON EL ID INGRESADO EN EL LAYOUT
        val til_email = findViewById<TextInputLayout>(R.id.til_email)
        val til_password = findViewById<TextInputLayout>(R.id.til_password)
        val btn_register = findViewById<Button>(R.id.btn_register)
        val btn_login = findViewById<Button>(R.id.btn_login)

        //LISTENER DE BOTONES
        btn_register.setOnClickListener {
            val intent = Intent(this@UserLogin,UserRegister::class.java)
            startActivity(intent)
        }

        /*btn_login.setOnClickListener {
            val intent = Intent(this@UserLogin,Category::class.java)
            startActivity(intent)
        }*/

        //CAPTURA DATOS Y LOS MUESTRA POR PANTALLA
        btn_login.setOnClickListener {
            var email = til_email.editText?.text.toString()
            var password = til_password.editText?.text.toString()

            Toast.makeText(this@UserLogin,email+" "+password,Toast.LENGTH_SHORT).show()
        }
    }
}