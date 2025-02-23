package com.example.taskbd.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taskbd.data.dao.BouquetDao
import com.example.taskbd.data.dao.BouquetFlowerCrossRefDao
import com.example.taskbd.data.dao.FlowerDao
import com.example.taskbd.data.entities.Bouquet
import com.example.taskbd.data.entities.BouquetFlowerCrossRef
import com.example.taskbd.data.entities.Flower

@Database(
    entities = [Flower::class, Bouquet::class, BouquetFlowerCrossRef::class],
    version = 2
)
abstract class MainDb : RoomDatabase() {
    abstract fun flowerDao(): FlowerDao
    abstract fun bouquetDao(): BouquetDao
    abstract fun bouquetFlowerCrossRefDao(): BouquetFlowerCrossRefDao

    companion object {
        fun createDataBase(context: Context): MainDb {
            return Room.databaseBuilder(
                context = context,
                MainDb::class.java,
                "test.db"
            ).addMigrations(MIGRATION_1_2).build()
        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE bouquets ADD COLUMN decoration TEXT NOT NULL DEFAULT 'Крафтовая бумага'")

                database.execSQL("ALTER TABLE flowers ADD COLUMN country TEXT NOT NULL DEFAULT 'Неизвестно'")
            }
        }
    }
}