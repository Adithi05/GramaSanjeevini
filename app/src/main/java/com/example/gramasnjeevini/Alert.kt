package com.example.gramasnjeevini

data class Alert(
    val medicineName: String = "",
    val category: String = "",
    val daysLeft: String = "",
    val units: String = "",
    val batch: String = "",
    val oldPrice: String = "",
    val newPrice: String = "",
    val pharmacy: String = ""
)