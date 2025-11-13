package com.example.apiretro.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.util.CoilUtils.result
import com.example.apiretro.model.GameList
import com.example.apiretro.repository.GamesRepository
import com.example.apiretro.state.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val repo: GamesRepository
) : ViewModel() {

    private val _games = MutableStateFlow<List<GameList>>(emptyList())
    val games = _games.asStateFlow()

    var state by mutableStateOf(GameState())
        private set

    init {
        fetchGames()
    }

    private fun fetchGames() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repo.getGame()
            }

            _games.value = response ?: emptyList()
        }
    }

    fun getGameById(id: Int) {
        viewModelScope.launch {
            val game = withContext(Dispatchers.IO) {
                repo.getGameById(id)
            }

            if (game != null) {
                state = state.copy(
                    name = game.name ?: "",
                    description_raw = game.description_raw ?: "",
                    metacritics = game.metacritics ?: 111,
                    website = game.website?:""
                )
            }
        }
    }

    fun clean(){
        state=state.copy(
            name = "",
            description_raw = "",
            metacritics = 0,
            website = ""
        )
    }
}

