package com.example.productfireapp.data.repositories

import com.example.productfireapp.domain.dao.ShippingAddressDao
import com.example.productfireapp.domain.models.ShippingAddress
import com.example.productfireapp.domain.repositories.ShippingAddressRepository
import javax.inject.Inject

class ShippingAddressRepositoryImpl @Inject constructor(
    private val dao: ShippingAddressDao
) : ShippingAddressRepository {
    override suspend fun insertAddress(item: ShippingAddress) {
        dao.insertAddress(item)
    }

    override suspend fun deleteAddress(item: ShippingAddress) {
        dao.deleteAddress(item)
    }
}