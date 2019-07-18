package com.jpatoc.eprofiler.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceManager {

    fun getUserApiService(): UserApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(UserApiService::class.java)
    }
}