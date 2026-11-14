package com.example.productfireapp.domain.repositories

import com.example.productfireapp.domain.models.CreditCart
import kotlinx.coroutines.flow.Flow

interface CreditCartRepository {
    suspend fun insertCart(item: CreditCart): Boolean
    suspend fun deleteCart(item: CreditCart): Boolean
    fun observeCarts(): Flow<List<CreditCart>>
    suspend fun updateDefault(cartId: Int)
}

