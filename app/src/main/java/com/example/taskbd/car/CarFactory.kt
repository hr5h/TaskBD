package com.example.taskbd.car

interface CarFactory {
    fun createSedan(): Car
    fun createSUV(): Car
}