package com.example.nutriscan.ui.theme


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.*
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp



@Composable

fun PrimaryButton(
    title: String,
    onClick : () -> Unit,
    icon: ImageVector,
    modifier: Modifier = Modifier,
){
    Button(
        onClick = onClick,
        modifier = modifier.height(53.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, color = black100),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 1.dp, pressedElevation = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MintGreen50,
            contentColor = black100
        )

    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = title,
            style = MainButtonTextStyle
        )
    }

}



