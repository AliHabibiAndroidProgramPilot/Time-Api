package com.sample.ali.timeapi

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.sample.ali.timeapi.api.ApiRepository
import com.sample.ali.timeapi.api.ApiRespond
import com.sample.ali.timeapi.api.MainModel
import com.sample.ali.timeapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedTimeZone = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val timeZones = arrayListOf(
            "America/Buenos_Aires",
            "America/Los_Angeles",
            "America/Mexico_City",
            "Asia/Dubai",
            "Asia/Gaza",
            "Asia/Seoul",
            "Australia/NSW",
            "Europe/Berlin",
            "Europe/Madrid",
            "Pacific/Apia",
            "Etc/GMT",
        )
        binding.txtSelectedTimeZone.text = timeZones[0]
        binding.timeZonesSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            timeZones
        )
        val getTimeByTimeZoneRespond = object : ApiRespond {
            override fun onRespond(respond: MainModel) {
                binding.txtTime.text = buildString {
                    append(respond.time)
                    append(':')
                    append(respond.seconds)
                }
                binding.progressBar.visibility = View.INVISIBLE
            }

            override fun onRespondFailure(error: String) {
                binding.txtTime.text = error
                binding.progressBar.visibility = View.INVISIBLE
            }
        }
        selectedTimeZone = timeZones[0]
        ApiRepository.instance.getTimeByTimeZone(selectedTimeZone, getTimeByTimeZoneRespond)
        binding.timeZonesSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    spinner: View?,
                    position: Int,
                    rowId: Long
                ) {
                    binding.progressBar.visibility = View.VISIBLE
                    selectedTimeZone = timeZones[position]
                    binding.txtSelectedTimeZone.text = timeZones[position]
                    ApiRepository.instance.getTimeByTimeZone(
                        selectedTimeZone,
                        getTimeByTimeZoneRespond
                    )
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    // Nothing
                }

            }
    }
}