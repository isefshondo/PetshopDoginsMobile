package com.example.petshopdoginsmobile.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.petshopdoginsmobile.model.entities.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAllProducts(): List<Product>

    @Query("SELECT * FROM products WHERE id =:productId")
    fun getProductById(productId: String): Product

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(vararg product: Product)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateProduct(product: Product)
}