package com.example.productfireapp.domain.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite",
    foreignKeys = [
        ForeignKey(
            entity = Vegetable::class,
            parentColumns = ["id"],
            childColumns = ["id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Favorite(
    @PrimaryKey
    val id: Int
)

