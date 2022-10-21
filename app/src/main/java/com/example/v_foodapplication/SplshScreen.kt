package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplshScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splsh_screen)

        val delay:Long = 4000
        Handler(this.mainLooper).postDelayed(
            {
            val intent = Intent(this, Category::class.java)
                startActivity(intent)
                finish()
            },delay
        )
    }
}