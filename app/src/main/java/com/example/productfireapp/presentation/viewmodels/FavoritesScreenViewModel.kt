package com.example.productfireapp.presentation.viewmodels

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.domain.dao.FavoritesDao
import com.example.productfireapp.domain.models.Favorite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesScreenViewModel @Inject constructor(
    private val dao: FavoritesDao
) : ViewModel() {
    val favorites: StateFlow<List<Favorite>> = dao.getAllFavorites()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(3000),
            initialValue = emptyList()
        )

    fun addFavorite(
        id: Int,
        bgColor: Color,
        image: Int,
        coast: Double,
        count: Int,
        name: String,
        weightValue: Double,
        weightParameter: String,
        isEventExist: Boolean,
        eventText: String,
        eventTextColor: Color
    ) {
        viewModelScope.launch {
            dao.insertFavorite(
                item = Favorite(
                    id = id,
                    bgColor = bgColor,
                    image = image,
                    coast = coast,
                    count = count,
                    name = name,
                    weightValue = weightValue,
                    weightParameter = weightParameter,
                    isEventExist = isEventExist,
                    eventText = eventText,
                    eventTextColor = eventTextColor
                )
            )
        }
    }

    fun deleteFavorite(
        id: Int
    ) {
        viewModelScope.launch {
            dao.delete(
                id = id
            )
        }
    }
}