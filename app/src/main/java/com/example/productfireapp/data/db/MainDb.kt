package com.example.productfireapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.productfireapp.domain.dao.BasketItemDao
import com.example.productfireapp.domain.dao.FavoritesDao
import com.example.productfireapp.domain.dao.VegetableDao
import com.example.productfireapp.domain.models.BasketItem
import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.models.Vegetable
import com.example.productfireapp.utils.ConvertColors

@TypeConverters(ConvertColors::class)
@Database(
    entities = [Vegetable::class, Favorite::class, BasketItem::class],
    version = 2,
    exportSchema = true
)
abstract class MainDb: RoomDatabase() {
    abstract fun vegetableDao(): VegetableDao
    abstract fun favoritesDao(): FavoritesDao
    abstract fun basketItemDao(): BasketItemDao
}