package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class ProductCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_create)

        val til_create_product_name = findViewById<TextInputLayout>(R.id.til_create_product_name)
        val til_create_product_brand = findViewById<TextInputLayout>(R.id.til_create_product_brand)
        val til_create_product_price = findViewById<TextInputLayout>(R.id.til_create_product_price)

        val btn_product_create = findViewById<Button>(R.id.btn_product_create)

        btn_product_create.setOnClickListener {

            var create_product_name = til_create_product_name.editText?.text.toString()
            var create_product_brand = til_create_product_brand.editText?.text.toString()
            var create_product_price = til_create_product_price.editText?.text.toString()

            val validate = Validate()
            if (validate.validarCampoNulo(create_product_name)) til_create_product_name.error = getString(R.string.null_field_error) else til_create_product_name.error = ""
            if (validate.validarCampoNulo(create_product_brand)) til_create_product_brand.error = getString(R.string.null_field_error) else til_create_product_brand.error = ""
            if (validate.validarCampoNulo(create_product_price)) til_create_product_price.error = getString(R.string.null_field_error) else til_create_product_price.error = ""

            Toast.makeText(this@ProductCreate, "Producto creado", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@ProductCreate,CategoryRead::class.java)
            startActivity(intent)
        }
    }
}