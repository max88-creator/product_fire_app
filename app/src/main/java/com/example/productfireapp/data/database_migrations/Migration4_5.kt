package com.example.productfireapp.data.database_migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val Migration4_5 = object : Migration(startVersion = 4, endVersion = 5) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL(
            """
                CREATE TABLE IF NOT EXISTS `credit_cart` (
                `id` INTEGER PRIMARY KEY AUTOINCREMENT,
                `name` TEXT NOT NULL,
                `number` TEXT NOT NULL,
                `monthYear` TEXT NOT NULL,
                `cvv` TEXT NOT NULL
            )
            """.trimIndent()
        )
    }
}

