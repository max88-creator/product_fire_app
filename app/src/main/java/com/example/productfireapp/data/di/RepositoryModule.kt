package com.example.productfireapp.data.di

import com.example.productfireapp.data.repositories.BasketItemRepositoryImpl
import com.example.productfireapp.data.repositories.FavoritesRepositoryImpl
import com.example.productfireapp.data.repositories.VegetableRepositoryImpl
import com.example.productfireapp.domain.repositories.BasketItemRepository
import com.example.productfireapp.domain.repositories.FavoritesRepository
import com.example.productfireapp.domain.repositories.VegetableRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindVegetableRepository(vegetableRepositoryImpl: VegetableRepositoryImpl): VegetableRepository

    @Binds
    @Singleton
    abstract fun bindFavoriteRepository(favoritesRepositoryImpl: FavoritesRepositoryImpl): FavoritesRepository

    @Binds
    @Singleton
    abstract fun bindBasketItemRepository(basketItemRepositoryImpl: BasketItemRepositoryImpl): BasketItemRepository
}