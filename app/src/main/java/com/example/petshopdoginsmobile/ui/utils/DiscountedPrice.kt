package com.example.petshopdoginsmobile.ui.utils

fun calculateDiscountedPrice(originalPrice: Double, discount: Double): Double{
    return (originalPrice * (100 - discount)) / 100
}