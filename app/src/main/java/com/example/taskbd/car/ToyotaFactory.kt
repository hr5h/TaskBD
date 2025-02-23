package com.example.taskbd.car

class ToyotaFactory : CarFactory {
    override fun createSedan(): Car {
        return Car.Builder()
            .setBrand("Toyota")
            .setModel("Camry")
            .setYear(2023)
            .setColor("White")
            .setEngine("V6")
            .setTransmission("Automatic")
            .build()
    }

    override fun createSUV(): Car {
        return Car.Builder()
            .setBrand("Toyota")
            .setModel("RAV4")
            .setYear(2023)
            .setColor("Blue")
            .setEngine("V4")
            .setTransmission("Automatic")
            .build()
    }
}