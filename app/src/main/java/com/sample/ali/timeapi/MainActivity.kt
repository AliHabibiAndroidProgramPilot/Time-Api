package com.sample.ali.timeapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.ali.timeapi.databinding.ActivityMainBinding
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}