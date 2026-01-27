package com.example.nutriscan.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.nutriscan.ui.theme.MintGreen30
import com.example.nutriscan.ui.theme.SecondTitleStyle
import com.example.nutriscan.ui.theme.TitleTextStyle



@Composable
fun MainLayout(
    mainTitle : String,
    secondTitle : String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    Column(
        modifier = modifier.fillMaxSize().background(MintGreen30)
    ) {
        Text(
            text = mainTitle,
            style = TitleTextStyle,
            softWrap = false,
            overflow = TextOverflow.Visible,
            modifier = modifier
                .padding(24.dp, top = 41.dp)
        )
        HorizontalDivider(
            modifier = modifier.padding(start = 32.dp, top = 10.dp).width(330.dp),
            thickness = 2.dp,
            color = Color.Black

        )
        Text(
            text = secondTitle,
            style= SecondTitleStyle,
            modifier = modifier
                .padding(24.dp, top = 11.dp)
        )
        Box(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}