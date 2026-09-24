package com.example.productfireapp.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.productfireapp.domain.models.BasketItem
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBasketItem(item: BasketItem)

    @Query("DELETE FROM favorite WHERE id = :id")
    suspend fun delete(id: Int): Int

    @Query("SELECT * FROM favorite")
    fun getAllItems(): Flow<List<BasketItem>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite WHERE id = :id)")
    suspend fun isBasketItem(id: Int): Boolean
}