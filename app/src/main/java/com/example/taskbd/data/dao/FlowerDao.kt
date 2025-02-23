package com.example.taskbd.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskbd.data.entities.Flower

@Dao
interface FlowerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(flower: Flower)

    @Update
    fun update(flower: Flower)

    @Query("SELECT * FROM ${Flower.FLOWER_TABLE_NAME}")
    fun getAllFlowers(): List<Flower>

    @Query("SELECT * FROM ${Flower.FLOWER_TABLE_NAME} WHERE id = :flowerId")
    fun getFlowerById(flowerId: Int): Flower
}