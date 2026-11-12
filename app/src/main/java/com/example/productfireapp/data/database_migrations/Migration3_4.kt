package com.example.productfireapp.data.database_migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val Migration3_4 = object : Migration(startVersion = 3, endVersion = 4) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL(
            """
                CREATE TABLE IF NOT EXISTS `shipping_address` (
                    `id` INTEGER PRIMARY KEY AUTOINCREMENT,
                    `name` TEXT NOT NULL,
                    `email` TEXT NOT NULL,
                    `phoneNumber` TEXT NOT NULL,
                    `address` TEXT NOT NULL,
                    `zipCode` TEXT,
                    `city` TEXT NOT NULL,
                    `country` TEXT NOT NULL
                )
            """.trimIndent()
        )
    }
}

