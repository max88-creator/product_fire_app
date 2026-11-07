package com.example.productfireapp.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.productfireapp.domain.models.BasketItem
import com.example.productfireapp.domain.models.Vegetable
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBasketItem(item: BasketItem)

    @Query("DELETE FROM basket_item WHERE id = :id")
    suspend fun delete(id: Int): Int

    @Query("SELECT vegetable.* FROM " +
            "vegetable INNER JOIN basket_item ON" +
            " vegetable.id = basket_item.id")
    fun getAllItems(): Flow<List<Vegetable>>

    @Query("SELECT EXISTS(SELECT 1 FROM basket_item WHERE id = :id)")
    suspend fun isBasketItem(id: Int): Boolean
}


