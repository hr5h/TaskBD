package com.example.taskbd

import android.app.Application
import com.example.taskbd.data.MainDb

class App : Application() {
    val database by lazy { MainDb.createDataBase(this) }
}