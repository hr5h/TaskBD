package com.example.taskbd.car

class FordFactory : CarFactory {
    override fun createSedan(): Car {
        return Car.Builder()
            .setBrand("Ford")
            .setModel("Fusion")
            .setYear(2023)
            .setColor("Black")
            .setEngine("V6")
            .setTransmission("Automatic")
            .build()
    }

    override fun createSUV(): Car {
        return Car.Builder()
            .setBrand("Ford")
            .setModel("Explorer")
            .setYear(2023)
            .setColor("Gray")
            .setEngine("V6")
            .setTransmission("Automatic")
            .build()
    }
}