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
import kotlin.math.roundToInt

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
//    fun Double.formatPricePrecise(): String {
//        val rounded = (this * 10).roundToInt() / 10.0
//        return if (rounded % 1 == 0.0) {
//            rounded.toInt().toString()
//        } else {
//            String.format("%.1f", rounded)
//        }
//    }
}


