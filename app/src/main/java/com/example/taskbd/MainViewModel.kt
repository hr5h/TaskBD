package com.example.taskbd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.taskbd.data.ApiClient
import com.example.taskbd.data.ApiService
import com.example.taskbd.data.BouquetWithFlowers
import com.example.taskbd.data.MainDb
import com.example.taskbd.data.entities.Bouquet
import com.example.taskbd.data.entities.BouquetFlowerCrossRef
import com.example.taskbd.data.entities.Flower
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val database: MainDb) : ViewModel() {

    init {
        CoroutineScope(Dispatchers.IO).launch {
            initData()
            getBouquets().forEach {
                println(it)
            }
            buyBouquet(2)
            buyBouquet(2)
            getBouquets().forEach {
                println(it)
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            fetchData()
        }
    }

    private fun initData() {
        val flowers = listOf(
            Flower(1, "Роза", "Белая", 100),
            Flower(2, "Роза", "Красная", 150),
            Flower(3, "Тюльпан", "Желтый", 200),
            Flower(4, "Тюльпан", "Красный", 180),
            Flower(5, "Лилия", "Белая", 120),
            Flower(6, "Лилия", "Розовая", 130),
            Flower(7, "Гвоздика", "Красная", 90),
            Flower(8, "Гвоздика", "Белая", 80),
            Flower(9, "Орхидея", "Фиолетовая", 70),
            Flower(10, "Орхидея", "Белая", 60)
        )

        flowers.forEach { database.flowerDao().insert(it) }

        val bouquets = listOf(
            Bouquet(1, "Букет из белых роз и тюльпанов"),
            Bouquet(2, "Букет из красных роз и лилий")
        )

        bouquets.forEach { database.bouquetDao().insert(it) }

        val bouquetFlowerCrossRefs = listOf(
            BouquetFlowerCrossRef(1, 1, 3),
            BouquetFlowerCrossRef(1, 3, 2),
            BouquetFlowerCrossRef(2, 2, 10),
            BouquetFlowerCrossRef(2, 5, 5)
        )

        bouquetFlowerCrossRefs.forEach { database.bouquetFlowerCrossRefDao().insert(it) }
    }

    private fun getBouquets(): List<BouquetWithFlowers> {
        return database.bouquetDao().getAllBouquets().map { bouquet ->
            database.bouquetDao().getBouquetWithFlowers(bouquet.id)
        }
    }

    private fun buyBouquet(bouquetId: Int) {
        val bouquetWithFlowers = database.bouquetDao().getBouquetWithFlowers(bouquetId)

        bouquetWithFlowers.flowers.forEach { flower ->
            val flowerInDb = database.flowerDao().getFlowerById(flower.id)
            val crossRef = database.bouquetFlowerCrossRefDao().getFlowersForBouquet(bouquetId)
                .find { it.flowerId == flower.id }
            val quantityToSubtract = crossRef?.quantity ?: 0
            flowerInDb.quantity -= quantityToSubtract
            database.flowerDao().update(flowerInDb)
        }
    }

    private suspend fun fetchData() {
        val apiService = ApiClient.retrofit.create(ApiService::class.java)
        val response = apiService.getData()
        println("Response: $response")
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return MainViewModel(database) as T
            }
        }
    }
}