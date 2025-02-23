package com.example.taskbd.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.taskbd.data.entities.Bouquet
import com.example.taskbd.data.BouquetWithFlowers

@Dao
interface BouquetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bouquet: Bouquet)

    @Query("SELECT * FROM ${Bouquet.BOUQUET_TABLE_NAME}")
    fun getAllBouquets(): List<Bouquet>

    @Transaction
    @Query("SELECT * FROM ${Bouquet.BOUQUET_TABLE_NAME} WHERE id = :bouquetId")
    fun getBouquetWithFlowers(bouquetId: Int): BouquetWithFlowers
}