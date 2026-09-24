package com.example.productfireapp.presentation.viewmodels

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.domain.models.Vegetable
import com.example.productfireapp.domain.repositories.VegetableRepository
import com.example.productfireapp.presentation.home_screen.Elements
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    val elements: Elements,
    private val repository: VegetableRepository
) : ViewModel() {

    val vegetableList = repository.getAllVegetable()


    fun getVegCount() {
        viewModelScope.launch {
            val count = repository.getVegetableCount()
            if (count == 0) {
                repository.insertVegetableList(items = elements.vegList)
            }
        }
    }

    fun incrementItem(vegetable: Vegetable) {
        viewModelScope.launch {
            repository.incrementCount(vegetable.id)
        }
    }

    fun decrementCount(vegetable: Vegetable) {
        if (vegetable.count > 0) {
            viewModelScope.launch {
                repository.decrementCount(vegetable.id)
            }
        } else {
            return
        }
    }
}
