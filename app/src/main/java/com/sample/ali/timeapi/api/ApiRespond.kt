package com.sample.ali.timeapi.api

interface ApiRespond {
    fun onRespond(respond: MainModel)
    fun onRespondFailure(error: String)
}