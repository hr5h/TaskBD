package com.example.taskbd.car

class Car private constructor(
    val brand: String,
    val model: String,
    val year: Int,
    val color: String,
    val engine: String,
    val transmission: String
) {
    class Builder {
        private var brand: String = ""
        private var model: String = ""
        private var year: Int = 2023
        private var color: String = "Black"
        private var engine: String = "V6"
        private var transmission: String = "Automatic"

        fun setBrand(brand: String) = apply { this.brand = brand }
        fun setModel(model: String) = apply { this.model = model }
        fun setYear(year: Int) = apply { this.year = year }
        fun setColor(color: String) = apply { this.color = color }
        fun setEngine(engine: String) = apply { this.engine = engine }
        fun setTransmission(transmission: String) = apply { this.transmission = transmission }

        fun build(): Car {
            return Car(brand, model, year, color, engine, transmission)
        }
    }

    override fun toString(): String {
        return "Car(brand='$brand', model='$model', year=$year, color='$color', engine='$engine', transmission='$transmission')"
    }
}