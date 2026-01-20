package com.example.nutriscan.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutriscan.domain.dtos.NutritionDataResponseDto
import com.example.nutriscan.network.RetrofitInstance
import kotlinx.coroutines.launch

class DataPageViewModel : ViewModel() {
    private val _nutritionData = mutableStateOf<NutritionDataResponseDto?>(null)
    val nutritionData : State<NutritionDataResponseDto?> = _nutritionData

    fun loadNutritionData(barcode: String){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getNutritionData(barcode)
                Log.d("NutritionData", "Réponse reçue = $response")
                Log.d("API", "Product = ${response.product}")
                _nutritionData.value = response
            }catch (e: Exception){
                Log.e("NutritionData","Erreur Data API",e)
            }
        }
    }
}