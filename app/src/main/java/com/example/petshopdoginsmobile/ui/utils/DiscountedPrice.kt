package com.example.petshopdoginsmobile.ui.utils

fun calculateDiscountedPrice(originalPrice: Double, discount: Double): Double{
    return originalPrice -  (discount * (discount / 100))
}