package com.example.productfireapp.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.productfireapp.domain.models.Vegetable
import kotlinx.coroutines.flow.Flow

@Dao
interface VegetableDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVegetableList(items: List<Vegetable>)

    @Query("SELECT COUNT(*) FROM vegetable")
    suspend fun getVegetableCount(): Int

    @Query("UPDATE vegetable SET count = count + 1 WHERE id = :id")
    suspend fun incrementCount(id: Int)

    @Query("UPDATE vegetable SET count = count - 1 WHERE id = :id")
    suspend fun decrementCount(id: Int)

    @Query("SELECT * FROM vegetable")
    fun getAllVegetable(): Flow<List<Vegetable>>
}