package com.example.petshopdoginsmobile.model.database

import android.provider.BaseColumns

object ProductContract {
    object ProductImageEntry : BaseColumns {
        const val TABLE_NAME = "product_image"
        const val COLUMN_NAME_TYPE = "type"
        const val COLUMN_NAME_DATA = "data"
    }

    object ProductEntry : BaseColumns {
        const val TABLE_NAME = "product"
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_CATEGORY = "category"
        const val COLUMN_NAME_COLOR = "color"
        const val COLUMN_NAME_DESCRIPTION = "description"
        const val COLUMN_NAME_IMAGES = "images" // This will be a foreign key
        const val COLUMN_NAME_BRAND = "brand"
        const val COLUMN_NAME_PRICE = "price"
        const val COLUMN_NAME_STOCK = "stock"
        const val COLUMN_NAME_SIZE = "size"
        const val COLUMN_NAME_NAME = "name"
    }

}
