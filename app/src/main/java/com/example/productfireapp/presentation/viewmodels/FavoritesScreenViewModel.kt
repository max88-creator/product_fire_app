package com.example.productfireapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.data.mappers.toFavorite
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
    private val repository: FavoritesRepository,
    private val favorite: Favorite
) : ViewModel() {
    val favorites: StateFlow<List<Favorite>> = repository.getAllFavorites()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(3000),
            initialValue = emptyList()
        )

    fun isFavorite(id: Int) {
        viewModelScope.launch {
            repository.isFavorite(id)
        }
    }

    fun insertToFavorites(vegetable: Vegetable) {
        viewModelScope.launch {
            val favorite = vegetable.toFavorite()
            repository.insertFavorite(item = favorite)
        }
    }


    fun deleteFavorite(id: Int) {
        viewModelScope.launch {
            repository.delete(favorite.id)
        }
    }


    fun checkList(vegetable: Vegetable): Boolean {
        val result = favorites.value.any { favorite ->
           vegetable.id == favorite.id
        }
        return result
    }
}


//    fun deleteFavorite(
//        id: Int
//    ) {
//        viewModelScope.launch {
//            dao.delete(
//                id = id
//            )
//        }
//   }


//    fun addFavorite(
//        id: Int,
//        bgColor: Color,
//        image: Int,
//        coast: Double,
//        count: Int,
//        name: String,
//        weightValue: Double,
//        weightParameter: String,
//        isEventExist: Boolean,
//        eventText: String,
//        eventTextColor: Color
//    ) {
//        viewModelScope.launch {
//            dao.insertFavorite(
//                item = Favorite(
//                    id = id,
//                    bgColor = bgColor,
//                    image = image,
//                    coast = coast,
//                    count = count,
//                    name = name,
//                    weightValue = weightValue,
//                    weightParameter = weightParameter,
//                    isEventExist = isEventExist,
//                    eventText = eventText,
//                    eventTextColor = eventTextColor
//                )
//            )
//        }
//    }


//            insertFavorite(
//                item = Favorite(
//                    id = 0,
//                    bgColor = Color.White,
//                    image = 0,
//                    coast = 0.0,
//                    count = 0,
//                    name = "",
//                    weightValue = 0.0,
//                    weightParameter = "",
//                    isEventExist = false,
//                    eventText = "",
//                    eventTextColor = Color.White
//                ))