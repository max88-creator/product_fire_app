package com.example.productfireapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.domain.repositories.VegetableRepository
import com.example.productfireapp.presentation.screens.home_screen.Elements
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    val elements: Elements,
    private val repository: VegetableRepository,
) : ViewModel() {


    val vegetableList = repository.getAllVegetable()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(3000),
            initialValue = emptyList()
        )

    fun getVegCount() {
        viewModelScope.launch {
            val count = repository.getVegetableCount()
            if (count == 0) {
                repository.insertVegetableList(items = elements.vegList)
            }
        }
    }

    fun addToBasket(id: Int) {
        viewModelScope.launch {
            repository.addToBasket(id)
        }
    }

    fun incrementItem(id: Int) {
        viewModelScope.launch {
            repository.incrementBasketItem(id)
        }
    }

    fun decrementCount(id: Int) {
        viewModelScope.launch {
            repository.decrementBasketItem(id)
        }
    }

    fun resetCount(id: Int) {
        viewModelScope.launch {
            repository.removeFromBasket(id)
        }
    }
}


