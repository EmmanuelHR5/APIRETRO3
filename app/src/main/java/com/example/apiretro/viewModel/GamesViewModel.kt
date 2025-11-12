package com.example.apiretro.viewModel

import androidx.lifecycle.ViewModel
import com.example.apiretro.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repo: GamesRepository) : ViewModel() {
}