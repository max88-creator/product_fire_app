package com.example.productfireapp.domain.repositories

import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.models.Vegetable
import kotlinx.coroutines.flow.Flow

interface VegetableRepository {
    suspend fun getVegetableCount(): Int
    suspend fun insertVegetableList(items: List<Vegetable>)
    suspend fun addToBasket(id: Int)
    suspend fun incrementBasketItem(id: Int)
    suspend fun decrementBasketItem(id: Int)
    suspend fun removeFromBasket(id: Int)
    fun getAllVegetable(): Flow<List<Vegetable>>
}

