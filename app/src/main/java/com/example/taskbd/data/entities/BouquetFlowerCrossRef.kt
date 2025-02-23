package com.example.taskbd.data.entities

import androidx.room.Entity
import com.example.taskbd.data.entities.BouquetFlowerCrossRef.Companion.BOUQUET_FLOWER_CROSS_TABLE_NAME

@Entity(tableName = BOUQUET_FLOWER_CROSS_TABLE_NAME, primaryKeys = ["bouquetId", "flowerId"])
data class BouquetFlowerCrossRef(
    val bouquetId: Int,
    val flowerId: Int,
    val quantity: Int
) {
    companion object {
        const val BOUQUET_FLOWER_CROSS_TABLE_NAME = "bouquet_flower_cross_ref"
    }
}