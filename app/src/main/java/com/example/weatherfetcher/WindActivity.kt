package com.example.weatherfetcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WindActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)

        val textViewHello = findViewById<TextView>(R.id.tvHello)
        textViewHello.text = "Hello from code"}}

