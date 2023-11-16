package com.example.petshopdoginsmobile.ui.utils

import java.text.NumberFormat
import java.util.Locale

fun Double.formatToCurrency(): String {
    val ptBr = Locale("pt", "BR")
    return NumberFormat.getCurrencyInstance(ptBr).format(this)
}