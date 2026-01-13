package com.example.nutriscan.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier

@Composable
fun DataPage(
    retour: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("DataPage Screen")

        Button(onClick = retour) {
            Text("retour")
        }
    }
}