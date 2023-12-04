package com.example.petshopdoginsmobile

import com.example.petshopdoginsmobile.model.room.AppDatabase
import android.content.Context
import com.example.petshopdoginsmobile.ui.repository.ProductRepository

object Graph {

    lateinit var db:AppDatabase
        private set

    val repository by lazy {
        ProductRepository(
            productDao = db.productDao()
        )
    }

    fun provide(context:Context){
        db = AppDatabase.getDatabase(context)
    }

}