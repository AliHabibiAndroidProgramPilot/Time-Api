package com.sample.ali.timeapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.ali.timeapi.api.ApiRepository
import com.sample.ali.timeapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val selectedTimeZone = "Asia/Singapore"
        ApiRepository.instance.getTimeByTimeZone(selectedTimeZone)
    }
}