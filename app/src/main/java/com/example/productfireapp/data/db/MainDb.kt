package com.example.productfireapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.productfireapp.domain.dao.BasketItemDao
import com.example.productfireapp.domain.dao.FavoritesDao
import com.example.productfireapp.domain.dao.ShippingAddressDao
import com.example.productfireapp.domain.dao.VegetableDao
import com.example.productfireapp.domain.models.BasketItem
import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.domain.models.ShippingAddress
import com.example.productfireapp.domain.models.Vegetable
import com.example.productfireapp.utils.ConvertColors
import com.example.productfireapp.utils.ConvertCountry

@TypeConverters(ConvertColors::class, ConvertCountry::class)
@Database(
    entities = [
        Vegetable::class, Favorite::class,
        BasketItem::class, ShippingAddress::class
               ],
    version = 4,
    exportSchema = true
)
abstract class MainDb: RoomDatabase() {
    abstract fun vegetableDao(): VegetableDao
    abstract fun favoritesDao(): FavoritesDao
    abstract fun basketItemDao(): BasketItemDao
    abstract fun shippingAddressDao(): ShippingAddressDao
}


