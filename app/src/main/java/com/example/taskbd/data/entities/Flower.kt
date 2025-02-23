package com.example.taskbd.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskbd.data.entities.Flower.Companion.FLOWER_TABLE_NAME

@Entity(tableName = FLOWER_TABLE_NAME)
data class Flower(
    @PrimaryKey val id: Int,
    val name: String,
    val color: String,
    var quantity: Int,
    val country: String = "Неизвестно"
) {
    companion object {
        const val FLOWER_TABLE_NAME = "flowers"
    }
}
