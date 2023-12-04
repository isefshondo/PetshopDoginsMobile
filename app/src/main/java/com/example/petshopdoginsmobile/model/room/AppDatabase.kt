package com.example.petshopdoginsmobile.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.petshopdoginsmobile.model.entities.Product
import com.example.petshopdoginsmobile.model.entities.ProductImage

@Database(
    entities = [Product::class, ProductImage::class],
    version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao():ProductDao

    companion object {
        @Volatile
        var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "dogin"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}