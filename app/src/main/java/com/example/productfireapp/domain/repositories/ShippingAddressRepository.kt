package com.example.productfireapp.domain.repositories

import com.example.productfireapp.domain.models.ShippingAddress

interface ShippingAddressRepository {
    suspend fun insertAddress(item: ShippingAddress)
    suspend fun deleteAddress(item: ShippingAddress)
}