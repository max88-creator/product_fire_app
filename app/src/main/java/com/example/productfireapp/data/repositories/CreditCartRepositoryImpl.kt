package com.example.productfireapp.data.repositories

import com.example.productfireapp.domain.dao.CreditCartDao
import com.example.productfireapp.domain.models.CreditCart
import com.example.productfireapp.domain.repositories.CreditCartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreditCartRepositoryImpl @Inject constructor(
    private val dao: CreditCartDao
) : CreditCartRepository {
    override suspend fun insertCart(item: CreditCart): Boolean {
        return dao.insertCart(item)
    }

    override suspend fun deleteCart(item: CreditCart): Boolean {
        return dao.deleteCart(item)
    }

    override fun observeCarts(): Flow<List<CreditCart>> {
        return dao.observeCarts()
    }

    override suspend fun updateDefault(cartId: Int) {
        dao.updateDefault(cartId)
    }
}

