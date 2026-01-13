package com.example.nutriscan.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomePage(

    navigateToHistory  : ()-> Unit,
    navigateToData  : ()-> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("HomePage")

        Button(
            onClick = { navigateToData() }
        ) {
            Text("Go to Data")
        }
        Button(
            onClick = { navigateToHistory() }
        ) {
            Text("Go to History")
        }


    }
}