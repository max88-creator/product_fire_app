package com.example.productfireapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.domain.models.Vegetable
import com.example.productfireapp.domain.repositories.FavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesScreenViewModel @Inject constructor(
    private val repository: FavoritesRepository
) : ViewModel() {
//    val favorites: StateFlow<List<Favorite>> = repository.getAllFavorites()
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(3000),
//            initialValue = emptyList()
//        )

    fun isFavorite(id: Int) {
        viewModelScope.launch {
            repository.isFavorite(id)
        }
    }

    fun insertToFavorites(vegetable: Vegetable) {
        viewModelScope.launch {
  //          val favorite = vegetable.toFavorite()
  //          repository.insertFavorite(item = favorite)
        }
    }


    fun deleteFavorite(id: Int) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }


//    fun checkList(vegetable: Vegetable): Boolean {
//        val result = favorites.value.any { favorite ->
//           vegetable.id == favorite.id
//        }
//        return result
//    }
}



