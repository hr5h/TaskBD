package com.example.taskbd.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.taskbd.data.entities.Bouquet
import com.example.taskbd.data.entities.BouquetFlowerCrossRef
import com.example.taskbd.data.entities.Flower

data class BouquetWithFlowers(
    @Embedded val bouquet: Bouquet,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = BouquetFlowerCrossRef::class,
            parentColumn = "bouquetId",
            entityColumn = "flowerId"
        )
    )
    val flowers: List<Flower>
)