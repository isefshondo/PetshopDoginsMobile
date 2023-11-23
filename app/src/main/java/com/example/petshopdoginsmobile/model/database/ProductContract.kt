package com.example.petshopdoginsmobile.model.database

import android.provider.BaseColumns

object ProductContract {
    object ProductEntry : BaseColumns {
        const val TABLE_NAME = "product"
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_CATEGORY = "category"
        // Adicione todas as outras colunas aqui
    }
}
