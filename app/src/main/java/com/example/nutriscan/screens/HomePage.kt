package com.example.nutriscan.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nutriscan.R
import com.example.nutriscan.layouts.MainLayout
import com.example.nutriscan.ui.theme.PrimaryButton
import com.example.nutriscan.ui.theme.ScannerScreen
import com.example.nutriscan.viewmodel.DataPageViewModel


@Composable
fun HomePage(

    navigateToHistory: () -> Unit, navigateToData: (String) -> Unit,
    viewModel: DataPageViewModel = viewModel()
) {
    var scannedCode: String? by remember { mutableStateOf("") }
    MainLayout(mainTitle = "Nutri Score", secondTitle = "Home Page") {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ScannerScreen(
                    onBarcodeDetected = {
                        code -> scannedCode = code
                    }
                )

                PrimaryButton(
                    onClick = {
                        if (scannedCode?.isNotEmpty() ?: false ) {
                        viewModel.loadNutritionData(scannedCode!!)
                        }
                    },
                    title = "Scan",
                    icon = ImageVector.vectorResource(id = R.drawable.ic_scan)
                )
                GetNutritionData(viewModel)
                PrimaryButton(
                    onClick = { navigateToHistory() },
                    title = "History",
                    icon = ImageVector.vectorResource(id = R.drawable.ic_history)
                )
            }


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