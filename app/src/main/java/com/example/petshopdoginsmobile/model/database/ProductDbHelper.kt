package com.example.petshopdoginsmobile.model.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

// methods to modifier db goes here
class ProductDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES_PRODUCT_IMAGE)
        db.execSQL(SQL_CREATE_ENTRIES_PRODUCT)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES_PRODUCT_ENTRY)
        db.execSQL(SQL_DELETE_ENTRIES_PRODUCT_IMAGE)
        onCreate(db)
    }

    companion object {
        const val DATABASE_NAME = "Products.db"
        const val DATABASE_VERSION = 1
        const val SQL_CREATE_ENTRIES_PRODUCT_IMAGE =
            "CREATE TABLE ${ProductContract.ProductImageEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${ProductContract.ProductImageEntry.COLUMN_NAME_TYPE} INTEGER," +
                    "${ProductContract.ProductImageEntry.COLUMN_NAME_DATA} TEXT)"

        const val SQL_CREATE_ENTRIES_PRODUCT =
            "CREATE TABLE ${ProductContract.ProductEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_ID} TEXT," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_CATEGORY} TEXT," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_COLOR} TEXT," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_DESCRIPTION} TEXT," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_IMAGES} INTEGER," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_BRAND} TEXT," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_PRICE} REAL," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_STOCK} INTEGER," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_SIZE} TEXT," +
                    "${ProductContract.ProductEntry.COLUMN_NAME_NAME} TEXT," +
                    "FOREIGN KEY(${ProductContract.ProductEntry.COLUMN_NAME_IMAGES}) REFERENCES ${ProductContract.ProductImageEntry.TABLE_NAME}(${BaseColumns._ID}))"


        const val SQL_DELETE_ENTRIES_PRODUCT_ENTRY =
            "DROP TABLE IF EXISTS ${ProductContract.ProductEntry.TABLE_NAME}"
        const val SQL_DELETE_ENTRIES_PRODUCT_IMAGE=
            "DROP TABLE IF EXISTS ${ProductContract.ProductImageEntry.TABLE_NAME}"
    }
}
