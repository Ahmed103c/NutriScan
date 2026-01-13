package com.example.nutriscan.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier

@Composable
fun HistoryPage(
    retour: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("HistoryPage Screen")

        Button(onClick = retour) {
            Text("retour")
        }
    }
}