package com.example.taskbd.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskbd.data.entities.BouquetFlowerCrossRef

@Dao
interface BouquetFlowerCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(crossRef: BouquetFlowerCrossRef)

    @Query("SELECT * FROM ${BouquetFlowerCrossRef.BOUQUET_FLOWER_CROSS_TABLE_NAME} WHERE bouquetId = :bouquetId")
    fun getFlowersForBouquet(bouquetId: Int): List<BouquetFlowerCrossRef>
}