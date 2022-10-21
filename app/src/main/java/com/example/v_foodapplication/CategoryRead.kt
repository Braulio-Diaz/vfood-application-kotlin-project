package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CategoryRead : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_read)

        val fab_product_delete = findViewById<FloatingActionButton>(R.id.fab_product_delete)
        val fab_product_update = findViewById<FloatingActionButton>(R.id.fab_product_update)
        val fab_product_create = findViewById<FloatingActionButton>(R.id.fab_product_create)

        fab_product_delete.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estas seguro de eliminar este elemento?")
            builder.setPositiveButton(android.R.string.ok) {
                dialog,
                    //ACCIÓN A REALIZAR
                    wich ->
                Toast.makeText(this, "Elemento eliminado", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton(android.R.string.cancel, null)
            builder.setNeutralButton("No estoy seguro", null)
            builder.show()

            //val intent = Intent(this@CategoryRead,ProductDelete::class.java)
            //startActivity(intent)
        }

        fab_product_update.setOnClickListener {
            val intent = Intent(this@CategoryRead,ProductUpdate::class.java)
            startActivity(intent)
        }

        fab_product_create.setOnClickListener {
            val intent = Intent(this@CategoryRead,ProductCreate::class.java)
            startActivity(intent)
        }
    }
}