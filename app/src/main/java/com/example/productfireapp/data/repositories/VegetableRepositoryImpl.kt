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

    override suspend fun incrementCount(id: Int) {
        dao.incrementCount(id)
    }

    override suspend fun decrementCount(id: Int) {
        dao.decrementCount(id)
    }

    override fun getAllVegetable(): Flow<List<Vegetable>> {
        return dao.getAllVegetable()
    }

//    override fun mapToFavorite(id: Int): Favorite {
//        return toFavorite()
//    }

}