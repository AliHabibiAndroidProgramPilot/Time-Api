package com.sample.ali.timeapi.api

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository private constructor() {
    companion object {
        private var apiRepository: ApiRepository? = null
        val instance: ApiRepository
            get() {
                if (apiRepository == null)
                    apiRepository = ApiRepository()
                return apiRepository!!
            }
    }
    fun getTimeByTimeZone(timeZone: String) {
        RetrofitService.apiService.getTimeByTimeZone(timeZone = timeZone).enqueue(
            object : Callback<MainModel> {
                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    Log.e("API_FAILURE", t.cause.toString())
                }

            }
        )
    }
}