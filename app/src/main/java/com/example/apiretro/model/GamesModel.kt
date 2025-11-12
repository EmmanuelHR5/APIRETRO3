package com.example.apiretro.model

data class GamesModel(
    val count:Int,
    val results: List<GameList>
)

data class GameList(
    val id:Int,
    val name:String,
    val image_background:String
)