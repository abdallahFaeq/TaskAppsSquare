package com.training.appssquaretaskone.composable

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorTextComponent(
    hintError:String
){
    Text(text = hintError,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall)
}