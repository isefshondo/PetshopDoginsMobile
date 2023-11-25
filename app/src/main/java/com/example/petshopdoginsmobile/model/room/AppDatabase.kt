package com.example.petshopdoginsmobile.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.entities.ProductImage

@Database(entities = [Product::class, ProductImage::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}

private lateinit var INSTANCE : AppDatabase

fun getDatabase(context: Context):AppDatabase
{
    if(!::INSTANCE.isInitialized)
    {
        INSTANCE=
            Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"cars_database")
                .fallbackToDestructiveMigration().build()

    }
    return INSTANCE
}

