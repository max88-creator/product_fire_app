package com.example.productfireapp.data.database_migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val Migration2_3 = object : Migration(startVersion = 2, endVersion = 3) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE favorite_new (
                id INTEGER NOT NULL,
                PRIMARY KEY(id),
                FOREIGN KEY(id) REFERENCES vegetable(id)
                    ON UPDATE NO ACTION
                    ON DELETE CASCADE
            )
        """.trimIndent())

        // 2. Переносим ID избранных товаров
        db.execSQL("""
            INSERT INTO favorite_new (id)
            SELECT favorite.id
            FROM favorite
            INNER JOIN vegetable
            ON favorite.id = vegetable.id
        """.trimIndent())

        // 3. Удаляем старую таблицу и переименовываем новую
        db.execSQL("DROP TABLE favorite")
        db.execSQL("ALTER TABLE favorite_new RENAME TO favorite")


        // 4. Создаём новую таблицу корзины
        db.execSQL("""
            CREATE TABLE basket_item_new (
                id INTEGER NOT NULL,
                PRIMARY KEY(id),
                FOREIGN KEY(id) REFERENCES vegetable(id)
                    ON UPDATE NO ACTION
                    ON DELETE CASCADE
            )
        """.trimIndent())

        // 5. Переносим ID товаров из старой корзины
        db.execSQL("""
            INSERT INTO basket_item_new (id)
            SELECT basket_item.id
            FROM basket_item
            INNER JOIN vegetable
            ON basket_item.id = vegetable.id
        """.trimIndent())

        // 6. Удаляем старую таблицу и переименовываем новую
        db.execSQL("DROP TABLE basket_item")
        db.execSQL("ALTER TABLE basket_item_new RENAME TO basket_item")
    }
}

