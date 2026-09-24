package com.example.productfireapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.data.mappers.toBasketItem
import com.example.productfireapp.domain.models.BasketItem
import com.example.productfireapp.domain.models.Vegetable
import com.example.productfireapp.domain.repositories.BasketItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketScreenViewModel @Inject constructor(
    private val repository: BasketItemRepository
): ViewModel() {
    val basketItems: StateFlow<List<BasketItem>> = repository.getAllItems()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(3000),
            initialValue = emptyList()
        )

    fun insertItem(vegetable: Vegetable) {
        viewModelScope.launch {
            val basketItem = vegetable.toBasketItem()
            repository.insertBasketItem(item = basketItem)
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }
}