package com.example.productfireapp.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.models.Vegetable
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(item: Favorite)

    @Query("DELETE FROM favorite WHERE id = :id")
    suspend fun delete(id: Int): Int

    @Query("SELECT vegetable. * FROM vegetable INNER JOIN favorite ON vegetable.id = favorite.id")
    fun getAllFavorites(): Flow<List<Vegetable>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite WHERE id = :id)")
    suspend fun isFavorite(id: Int): Boolean
}


