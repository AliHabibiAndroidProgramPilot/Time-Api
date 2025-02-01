package com.sample.ali.timeapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.ali.timeapi.api.ApiRepository
import com.sample.ali.timeapi.api.ApiRespond
import com.sample.ali.timeapi.api.MainModel
import com.sample.ali.timeapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val getTimeByTimeZoneRespond = object : ApiRespond {
            override fun onRespond(respond: MainModel) {
                binding.txtTime.text = buildString {
                    append(respond.time)
                    append(':')
                    append(respond.seconds)
                }
            }

            override fun onRespondFailure(error: String) {
                binding.txtTime.text = error
            }
        }
        val selectedTimeZone = "Asia/Istanbul"
        ApiRepository.instance.getTimeByTimeZone(selectedTimeZone, getTimeByTimeZoneRespond)
    }
}