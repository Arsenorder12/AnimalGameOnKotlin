package com.example.kotlin1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result = intent.getStringExtra("key")
        binding.resultTv.text = result
    }
}