package com.example.petshopdoginsmobile.model.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

// methods to modifier db goes here
class ProductDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {
        const val DATABASE_NAME = "Products.db"
        const val DATABASE_VERSION = 1
        const val SQL_CREATE_ENTRIES = "CREATE TABLE ${ProductContract.ProductEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${ProductContract.ProductEntry.COLUMN_NAME_ID} TEXT," +
                "${ProductContract.ProductEntry.COLUMN_NAME_CATEGORY} TEXT" +
                // Adicione todas as outras colunas aqui
                ")"
        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${ProductContract.ProductEntry.TABLE_NAME}"
    }
}
