package com.example.app.data.local.remote

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface Api {

    @POST("api/v1/products")
    fun insert():Int {

    }
}