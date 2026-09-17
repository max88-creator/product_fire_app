package com.example.productfireapp.data.di

import com.example.productfireapp.data.repositories.VegetableRepositoryImpl
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
}