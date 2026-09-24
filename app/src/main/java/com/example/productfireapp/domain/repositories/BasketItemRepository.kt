package com.example.productfireapp.domain.repositories

import com.example.productfireapp.domain.models.BasketItem
import kotlinx.coroutines.flow.Flow

interface BasketItemRepository {
    suspend fun insertBasketItem(item: BasketItem)
    suspend fun delete(id: Int): Int
    fun getAllItems(): Flow<List<BasketItem>>
    suspend fun isBasketItem(id: Int): Boolean
}