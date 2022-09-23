package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProductUpdate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_update)

        val btn_product_update = findViewById<Button>(R.id.btn_product_update)

        btn_product_update.setOnClickListener {
            val intent = Intent(this@ProductUpdate,CategoryRead::class.java)
            startActivity(intent)
        }
    }
}