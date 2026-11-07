package com.example.productfireapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productfireapp.domain.repositories.BasketItemRepository
import com.example.productfireapp.domain.repositories.VegetableRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketScreenViewModel @Inject constructor(
    private val vegetableRepository: VegetableRepository,
    private val basketItemRepository: BasketItemRepository,
) : ViewModel() {

    val basketItemState = basketItemRepository.getAllItems()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(3000),
            initialValue = emptyList()
        )

    fun delete(id: Int) {
        viewModelScope.launch {
            vegetableRepository.removeFromBasket(id)
        }
    }
}


