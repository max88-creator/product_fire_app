package com.example.productfireapp.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.productfireapp.domain.models.CreditCart
import kotlinx.coroutines.flow.Flow

@Dao
interface CreditCartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCart(item: CreditCart): Boolean

    @Delete
    suspend fun deleteCart(item: CreditCart): Boolean

    @Query("SELECT * FROM credit_cart")
    fun observeCarts(): Flow<List<CreditCart>>

    @Query("SELECT COUNT(*) FROM credit_cart")
    suspend fun getCartsCount(): Int

    @Query("SELECT * FROM credit_cart WHERE isDefault = 1")
    suspend fun getDefaultCart(): CreditCart?

    @Query("UPDATE credit_cart SET isDefault = 0")
    suspend fun resetDefault()

    @Query("UPDATE credit_cart SET isDefault = 1 WHERE id = :cartId")
    suspend fun setDefault(cartId: Int)

    @Transaction
    suspend fun updateDefault(cartId: Int) {
        resetDefault()
        setDefault(cartId)
    }
}

