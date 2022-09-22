package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val fab_delete = findViewById<FloatingActionButton>(R.id.fab_delete)
        val fab_update = findViewById<FloatingActionButton>(R.id.fab_update)
        val fab_create = findViewById<FloatingActionButton>(R.id.fab_create)
        val fab_read = findViewById<FloatingActionButton>(R.id.fab_read)

        fab_delete.setOnClickListener {
            val intent = Intent(this@Category,CategoryDelete::class.java)
            startActivity(intent)
        }

        fab_update.setOnClickListener {
            val intent = Intent(this@Category,CategoryUpdate::class.java)
            startActivity(intent)
        }

        fab_create.setOnClickListener {
            val intent = Intent(this@Category,CategoryCreate::class.java)
            startActivity(intent)
        }

        fab_read.setOnClickListener {
            val intent = Intent(this@Category,CategoryRead::class.java)
            startActivity(intent)
        }
    }
}