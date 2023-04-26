package com.khanappsnj.characterviewer.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://api.duckduckgo.com/"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun createInstance(): CharacterApi {
            return retrofit.create(CharacterApi::class.java)
        }
    }
}
