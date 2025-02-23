package com.example.taskbd.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskbd.data.dao.BouquetDao
import com.example.taskbd.data.dao.BouquetFlowerCrossRefDao
import com.example.taskbd.data.dao.FlowerDao
import com.example.taskbd.data.entities.Bouquet
import com.example.taskbd.data.entities.BouquetFlowerCrossRef
import com.example.taskbd.data.entities.Flower

@Database(
    entities = [Flower::class, Bouquet::class, BouquetFlowerCrossRef::class],
    version = 1
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
            ).build()
        }
    }
}