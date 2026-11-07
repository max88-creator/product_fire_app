package com.example.productfireapp.data.repositories

import com.example.productfireapp.domain.dao.VegetableDao
import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.models.Vegetable
import com.example.productfireapp.domain.repositories.VegetableRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VegetableRepositoryImpl @Inject constructor(
    private val dao: VegetableDao
) : VegetableRepository {
    override suspend fun getVegetableCount(): Int {
        return dao.getVegetableCount()
    }

    override suspend fun insertVegetableList(items: List<Vegetable>) {
        dao.insertVegetableList(items = items)
    }

    override suspend fun addToBasket(id: Int) {
        dao.addToBasket(id)
    }

    override suspend fun incrementBasketItem(id: Int) {
        dao.incrementBasketItem(id)
    }

    override suspend fun decrementBasketItem(id: Int) {
        dao.decrementBasketItem(id)
    }

    override suspend fun removeFromBasket(id: Int) {
        dao.removeFromBasket(id)
    }

    override fun getAllVegetable(): Flow<List<Vegetable>> {
        return dao.getAllVegetable()
    }
}

