package com.example.nutriscan.network

import com.example.nutriscan.domain.dtos.NutritionDataResponseDto;
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataPageService {
    @GET("product/{barcode}.json")
    suspend fun getNutritionData(@Path("barcode") barcode: String) : NutritionDataResponseDto
}