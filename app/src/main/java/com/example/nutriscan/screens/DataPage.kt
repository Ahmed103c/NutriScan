package com.example.nutriscan.screens


import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.nutriscan.R
import com.example.nutriscan.layouts.MainLayout
import com.example.nutriscan.ui.theme.PrimaryButton

@Composable
fun DataPage(
    retour: () -> Unit
) {
    MainLayout(mainTitle = "Nutri Score", secondTitle = "Data Page") {
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        PrimaryButton(
            title = "Return",
            onClick = retour,
            icon = ImageVector.vectorResource(id = R.drawable.ic_back)

        )
    }
}