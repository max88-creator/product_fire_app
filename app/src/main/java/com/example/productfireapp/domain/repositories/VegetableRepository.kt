package com.example.productfireapp.domain.repositories

import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.models.Vegetable
import kotlinx.coroutines.flow.Flow

interface VegetableRepository {
    suspend fun getVegetableCount(): Int
    suspend fun insertVegetableList(items: List<Vegetable>)
    suspend fun incrementCount(id: Int)
    suspend fun decrementCount(id: Int)
    suspend fun resetCount(id: Int)
    fun getAllVegetable(): Flow<List<Vegetable>>
}

