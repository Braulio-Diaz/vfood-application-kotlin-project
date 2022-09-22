package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val fab_category_delete = findViewById<FloatingActionButton>(R.id.fab_category_delete)
        val fab_category_update = findViewById<FloatingActionButton>(R.id.fab_category_update)
        val fab_category_create = findViewById<FloatingActionButton>(R.id.fab_category_create)
        val fab_category_read = findViewById<FloatingActionButton>(R.id.fab_category_read)

        fab_category_delete.setOnClickListener {
            val intent = Intent(this@Category,CategoryDelete::class.java)
            startActivity(intent)
        }

        fab_category_update.setOnClickListener {
            val intent = Intent(this@Category,CategoryUpdate::class.java)
            startActivity(intent)
        }

        fab_category_create.setOnClickListener {
            val intent = Intent(this@Category,CategoryCreate::class.java)
            startActivity(intent)
        }

        fab_category_read.setOnClickListener {
            val intent = Intent(this@Category,CategoryRead::class.java)
            startActivity(intent)
        }
    }
}