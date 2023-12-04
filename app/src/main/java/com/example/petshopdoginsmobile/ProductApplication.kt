package com.example.petshopdoginsmobile
import android.app.Application
class ProductApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}
