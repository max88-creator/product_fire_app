package com.example.productfireapp.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CategoryDao {
    @Insert()
    fun insertCateGory(item: Category)
}