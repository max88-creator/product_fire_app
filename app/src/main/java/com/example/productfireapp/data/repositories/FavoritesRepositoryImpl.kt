package com.example.productfireapp.data.repositories

import com.example.productfireapp.domain.dao.FavoritesDao
import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.repositories.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val dao: FavoritesDao
) : FavoritesRepository {
    override suspend fun insertFavorite(item: Favorite) {
        dao.insertFavorite(item)
    }

    override suspend fun delete(id: Int): Int {
        return dao.delete(id)
    }

    override fun getAllFavorites(): Flow<List<Favorite>> {
        return dao.getAllFavorites()
    }

    override suspend fun isFavorite(id: Int): Boolean {
        return dao.isFavorite(id)
    }

}