package com.jpatoc.eprofiler.api

import com.jpatoc.eprofiler.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface UserApiService {
    @GET("/api?results=15")
    fun getUsers(): Call<UserResponse>
}