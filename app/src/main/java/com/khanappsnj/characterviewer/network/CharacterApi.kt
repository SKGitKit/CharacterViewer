package com.khanappsnj.characterviewer.network

import com.khanappsnj.characterviewer.data.Characters
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("/")
    suspend fun getCharacters(
        @Query("q") query: String,
        @Query("format") format: String = "json"
    ): Response<Characters>
}