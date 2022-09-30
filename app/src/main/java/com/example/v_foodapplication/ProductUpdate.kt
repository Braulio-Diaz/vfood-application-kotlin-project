package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class ProductUpdate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_update)

        val til_product_update_name = findViewById<TextInputLayout>(R.id.til_product_update_name)
        val til_product_update_brand = findViewById<TextInputLayout>(R.id.til_product_update_brand)
        val til_product_update_price = findViewById<TextInputLayout>(R.id.til_product_update_price)
        val btn_product_update = findViewById<Button>(R.id.btn_product_update)

        btn_product_update.setOnClickListener {

            var product_update_name = til_product_update_name.editText?.text.toString()
            var product_update_brand = til_product_update_brand.editText?.text.toString()
            var product_update_price = til_product_update_price.editText?.text.toString()

            val validate = Validate()
            if (validate.validarCampoNulo(product_update_name)) til_product_update_name.error = getString(R.string.null_field_error) else til_product_update_name.error = ""
            if (validate.validarCampoNulo(product_update_brand)) til_product_update_brand.error = getString(R.string.null_field_error) else til_product_update_brand.error = ""
            if (validate.validarCampoNulo(product_update_price)) til_product_update_price.error = getString(R.string.null_field_error) else til_product_update_price.error = ""

            val intent = Intent(this@ProductUpdate,CategoryRead::class.java)
            startActivity(intent)
        }
    }
}