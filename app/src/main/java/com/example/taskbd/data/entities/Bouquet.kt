package com.example.taskbd.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskbd.data.entities.Bouquet.Companion.BOUQUET_TABLE_NAME

@Entity(tableName = BOUQUET_TABLE_NAME)
data class Bouquet(
    @PrimaryKey val id: Int,
    val name: String
) {
    companion object {
        const val BOUQUET_TABLE_NAME = "bouquets"
    }
}