package com.example.productfireapp.domain.repositories

import com.example.productfireapp.domain.models.BasketItem
import com.example.productfireapp.domain.models.Vegetable
import kotlinx.coroutines.flow.Flow

interface BasketItemRepository {
    suspend fun insertBasketItem(item: BasketItem)
    suspend fun delete(id: Int): Int
    fun getAllItems(): Flow<List<Vegetable>>
    suspend fun isBasketItem(id: Int): Boolean
}

