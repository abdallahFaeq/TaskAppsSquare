package com.training.appssquaretaskone.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.training.appssquaretaskone.R

@Composable
fun HeadLineTextComponent(
    text:String
){
    Text(text = text,
        fontSize = 37.sp,
        fontWeight = FontWeight(600)
    )
}