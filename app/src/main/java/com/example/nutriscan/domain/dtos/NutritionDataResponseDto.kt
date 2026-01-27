package com.example.nutriscan.domain.dtos

import com.google.gson.annotations.SerializedName

data class NutritionDataResponseDto(
    val code: String,
    val product: ProductDto?
)

data class ProductDto(
    @SerializedName("product_name")
    val productName: String?,
    val brands: String?
)