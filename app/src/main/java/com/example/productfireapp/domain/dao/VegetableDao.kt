package com.example.productfireapp.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.productfireapp.domain.models.Vegetable
import kotlinx.coroutines.flow.Flow

@Dao
interface VegetableDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVegetableList(items: List<Vegetable>)
    @Query("SELECT COUNT(*) FROM vegetable")
    suspend fun getVegetableCount(): Int
    @Query("SELECT * FROM vegetable")
    fun getAllVegetable(): Flow<List<Vegetable>>

    @Query("SELECT count FROM vegetable WHERE id = :id")
    suspend fun getProductCount(id: Int): Int?

    @Query("""
        UPDATE vegetable SET count = 1 
WHERE id = :id AND count = 0
    """)
    suspend fun setCountToOne(id: Int)

    @Query("UPDATE vegetable SET count = count + 1 WHERE id = :id")
    suspend fun increaseProductCount(id: Int)

    @Query("UPDATE vegetable SET count = count - 1 WHERE id = :id AND count > 1")
    suspend fun decreaseProductCount(id: Int)
   @Query("UPDATE vegetable SET count = 0 WHERE id = :id")
   suspend fun setCountToZero(id: Int)
    @Query("INSERT OR IGNORE INTO basket_item (id) VALUES (:id)")
    suspend fun insertBasketReference(id: Int)

    @Query("DELETE FROM basket_item WHERE id = :id")
    suspend fun deleteBasketReference(id: Int)

    @Transaction
    suspend fun addToBasket(id: Int) {
        setCountToOne(id)
        insertBasketReference(id)
    }

    @Transaction
    suspend fun incrementBasketItem(id: Int) {
        increaseProductCount(id)
    }

    @Transaction
    suspend fun decrementBasketItem(id: Int) {
        val currentCount = getProductCount(id) ?: return

        when {
            currentCount <= 0 -> return
            currentCount == 1 -> {
                setCountToZero(id)
                deleteBasketReference(id)
            }
            else -> decreaseProductCount(id)
        }
    }

    @Transaction
    suspend fun removeFromBasket(id: Int) {
        setCountToZero(id)
        deleteBasketReference(id)
    }
}


