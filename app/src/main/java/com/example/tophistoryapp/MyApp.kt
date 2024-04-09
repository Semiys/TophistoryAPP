package com.example.tophistoryapp

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Установите ваш API ключ здесь
        MapKitFactory.setApiKey("b24e54ca-8c0c-4986-a17a-091f18cbe011")
        MapKitFactory.initialize(this)
    }
}