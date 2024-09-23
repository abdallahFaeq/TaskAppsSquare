package com.training.appssquaretaskone.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun ImageComponent(
    painter:Painter,
){
    Image(
        painter = painter,
        contentDescription = "",
        modifier = Modifier.fillMaxWidth()
    )
}