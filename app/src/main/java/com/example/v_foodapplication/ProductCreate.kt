package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProductCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_create)

        val btn_product_create = findViewById<Button>(R.id.btn_product_create)

        btn_product_create.setOnClickListener {
            val intent = Intent(this@ProductCreate,CategoryRead::class.java)
            startActivity(intent)
        }
    }
}