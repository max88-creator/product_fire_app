package com.example.productfireapp.data.database_migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION5_6 = object: Migration(startVersion = 5, endVersion = 6) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE `credit_cart` ADD COLUMN `isDefault` INTEGER NOT NULL DEFAULT 0")
    }
}

