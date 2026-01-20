package com.example.nutriscan.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nutriscan.viewmodel.DataPageViewModel

@Composable
fun DataPage(
    retour: () -> Unit,
    viewModel: DataPageViewModel = viewModel()
) {
    var barcode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),

        verticalArrangement = Arrangement.Center
    ) {
        Text("DataPage Screen")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = barcode,
            onValueChange = { newValue -> barcode = newValue }, // Met à jour l'état
            label = { Text("Entrez le code-barres") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        // 🔹 Bouton pour lancer la recherche
        Button(
            onClick = {
                if (barcode.isNotBlank()) {
                    viewModel.loadNutritionData(barcode)
                }
            }
        ) {
            Text("Rechercher")
        }

        Spacer(modifier = Modifier.height(16.dp))



        GetNutritionData(viewModel)

        Button(onClick = retour) {
            Text("retour")

        }
    }
}

@Composable
fun GetNutritionData(viewModel: DataPageViewModel) {

    val nutrition by viewModel.nutritionData

    nutrition?.let { product ->
        Column {
            Text("Nom: ${product.product?.productName}")
        }
    } ?: Text("Aucune donnée")
}