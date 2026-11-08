package com.example.productfireapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.models.Vegetable
import com.example.productfireapp.domain.repositories.FavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesScreenViewModel @Inject constructor(
    private val repository: FavoritesRepository
) : ViewModel() {
    val favorites: StateFlow<List<Vegetable>> = repository.getAllFavorites()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(3000),
            initialValue = emptyList()
        )

    fun insertFavorite(id: Int) {
        viewModelScope.launch {
            repository.insertFavorite(item = Favorite(id))
        }
    }

    fun deleteFavorite(id: Int) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }
}

