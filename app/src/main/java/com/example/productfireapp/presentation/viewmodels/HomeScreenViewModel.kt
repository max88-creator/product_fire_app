package com.example.productfireapp.presentation.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.R
import com.example.productfireapp.data.CategoryE
import com.example.productfireapp.data.Vegetable
import com.example.productfireapp.presentation.home_screen.Elements
import com.example.productfireapp.ui.theme.AvocadoColor
import com.example.productfireapp.ui.theme.GrapesColor
import com.example.productfireapp.ui.theme.LightPrimary
import com.example.productfireapp.ui.theme.PeachColor
import com.example.productfireapp.ui.theme.PineapleColor
import com.example.productfireapp.ui.theme.PomegranateColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
   val elements: Elements
): ViewModel() {

    fun addToFavoriteList(vegetable: Vegetable) {
        val index = elements.vegList.indexOf(vegetable)
        if (index != -1) {
            elements.vegList[index] = elements.vegList[index].copy(
                isFavorite = !elements.vegList[index].isFavorite
            )
        }
    }

//    fun addItem(vegetable: Vegetable) {
//        val index = elements.vegList.indexOf(vegetable)
//        if (index != -1) {
//            elements.vegList[index] = elements.vegList[index].copy(
//                count = 1
//            )
//        }
//    }
    fun incrementItem(vegetable: Vegetable) {
        val index = elements.vegList.indexOf(vegetable)
        if (index != -1) {
            elements.vegList[index] = elements.vegList[index].copy(
                count = elements.vegList[index].count + 1
            )
        }
    }
    fun decrementItem(vegetable: Vegetable) {
        val index = elements.vegList.indexOf(vegetable)
        if (index != -1) {
            elements.vegList[index] = elements.vegList[index].copy(
                count = (elements.vegList[index].count - 1).coerceAtLeast(minimumValue = 0)
            )
        }
    }
}