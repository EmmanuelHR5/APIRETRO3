package com.example.apiretro.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.apiretro.component.MainTopBar
import com.example.apiretro.model.GameList
import com.example.apiretro.viewModel.GamesViewModel

@Composable
fun HomeView(viewModel: GamesViewModel){
    Scaffold(
        topBar = {
            MainTopBar(title = "API GAMES", onClickBackButton ={} ) {

            }
        }
    ) {
        ContentHomeView(viewModel,it)
    }
}

@Composable
fun ContentHomeView(viewModel: GamesViewModel,paddingValues: PaddingValues){
    val games:List<GameList> by viewModel.games.collectAsState()
}