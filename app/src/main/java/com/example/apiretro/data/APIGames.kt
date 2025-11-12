package com.example.apiretro.data

import com.example.apiretro.model.GamesModel
import com.example.apiretro.model.SingleGameModel
import com.example.apiretro.utils.Constants.Companion.API_KEY
import com.example.apiretro.utils.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIGames {
    @GET(ENDPOINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>

    @GET("$ENDPOINT/{id$API_KEY}")
    suspend fun getGameById(@Path("id") id: Int): Response<SingleGameModel>
}