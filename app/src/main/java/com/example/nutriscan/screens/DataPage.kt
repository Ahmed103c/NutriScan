package com.example.nutriscan.screens


import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
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
        modifier = Modifier.fillMaxSize().padding(16.dp),

        verticalArrangement = Arrangement.Center
    ) {

        PrimaryButton(
            title = "Return",
            onClick = retour,
            icon = ImageVector.vectorResource(id = R.drawable.ic_back)

        )
    }
}

