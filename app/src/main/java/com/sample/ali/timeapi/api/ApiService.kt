package com.sample.ali.timeapi.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("zone")
    fun getTimeByTimeZone(@Query("timeZone") timeZone: String): Call<String>
}