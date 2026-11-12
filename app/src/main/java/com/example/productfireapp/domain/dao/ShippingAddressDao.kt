package com.example.productfireapp.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.productfireapp.domain.models.ShippingAddress

@Dao
interface ShippingAddressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAddress(item: ShippingAddress)
    @Delete
    suspend fun deleteAddress(item: ShippingAddress)
}