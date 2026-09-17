package com.example.productfireapp.data.di

import android.app.Application
import androidx.room.Room
import com.example.productfireapp.data.db.MainDb
import com.example.productfireapp.domain.dao.FavoritesDao
import com.example.productfireapp.domain.dao.VegetableDao
import com.example.productfireapp.utils.ConvertColors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(
            context = app,
            klass = MainDb::class.java,
            name = "main_db"
        ).build()
    }

    @Provides
    fun provideVegetableDao(mainDb: MainDb): VegetableDao {
        return mainDb.vegetableDao()
    }

    @Provides
    fun provideFavoriteDao(mainDb: MainDb): FavoritesDao {
        return mainDb.favoritesDao()
    }

}