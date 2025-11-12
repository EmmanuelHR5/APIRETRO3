package com.example.apiretro.repository

import com.example.apiretro.data.APIGames
import com.example.apiretro.model.GameList
import com.example.apiretro.model.SingleGameModel
import retrofit2.Response
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: APIGames){
    suspend fun getGame():List<GameList>?{
        val response=apiGames.getGames()
        if(response.isSuccessful){
            return response.body()?.results
        }
        return null
    }
    suspend fun getGameById(id: Int): SingleGameModel?{
        val response: Response<SingleGameModel>
                = apiGames.getGameById(id)
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }
}