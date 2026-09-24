package com.example.productfireapp.data.repositories

import com.example.productfireapp.domain.dao.BasketItemDao
import com.example.productfireapp.domain.models.BasketItem
import com.example.productfireapp.domain.repositories.BasketItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BasketItemRepositoryImpl @Inject constructor(
    private val dao: BasketItemDao
) : BasketItemRepository {
    override suspend fun insertBasketItem(item: BasketItem) {
        dao.insertBasketItem(item)
    }

    override suspend fun delete(id: Int): Int {
        return dao.delete(id)
    }

    override fun getAllItems(): Flow<List<BasketItem>> {
        return dao.getAllItems()
    }

    override suspend fun isBasketItem(id: Int): Boolean {
        return dao.isBasketItem(id)
    }

}