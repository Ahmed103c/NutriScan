package com.example.nutriscan.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.nutriscan.R
import com.example.nutriscan.layouts.MainLayout
import com.example.nutriscan.ui.theme.PrimaryButton


@Composable
fun HomePage(

    navigateToHistory  : ()-> Unit,
    navigateToData  : ()-> Unit
) {
    MainLayout(mainTitle = "Nutri Score", secondTitle = "Home Page") {
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryButton(
                onClick = { navigateToData() },
                title = "Scan",
                icon = ImageVector.vectorResource(id = R.drawable.ic_scan)
            )
            PrimaryButton(
                onClick = { navigateToHistory() },
                title = "History",
                icon = ImageVector.vectorResource(id = R.drawable.ic_history)
            )
        }


    }
}