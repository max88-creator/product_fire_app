package com.example.productfireapp.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.productfireapp.domain.models.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(item: Favorite)

    @Query("DELETE FROM favorite WHERE id = :id")
    suspend fun delete(id: Int): Int

    @Query("SELECT * FROM favorite")
    fun getAllFavorites(): Flow<List<Favorite>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite WHERE id = :id)")
    suspend fun isFavorite(id: Int): Boolean
}