package com.example.productfireapp.domain.repositories

import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.models.Vegetable
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    suspend fun insertFavorite(item: Favorite)
    suspend fun delete(id: Int): Int
    fun getAllFavorites(): Flow<List<Vegetable>>
    suspend fun isFavorite(id: Int): Boolean
}

