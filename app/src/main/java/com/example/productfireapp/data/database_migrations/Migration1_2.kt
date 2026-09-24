package com.example.productfireapp.data.database_migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val Migration1_2 = object : Migration(startVersion = 1, endVersion = 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE IF NOT EXISTS basket_item (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                bgColor INTEGER NOT NULL,
                image INTEGER NOT NULL,
                coast REAL NOT NULL,
                count INTEGER NOT NULL,
                name TEXT NOT NULL,
                weightValue REAL NOT NULL,
                weightParameter TEXT NOT NULL,
                isEventExist INTEGER NOT NULL,
                eventText TEXT NOT NULL,
                eventTextColor INTEGER NOT NULL
            )
            """.trimIndent()
        )
    }
}