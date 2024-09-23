package com.training.appssquaretaskone.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.training.appssquaretaskone.R

@Composable
fun RefreshScreen(
    navController:NavHostController
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.sign_up_image),
            contentDescription = "",
            modifier = Modifier
                .size(width = 204.dp, height = 188.dp))

     Spacer(modifier = Modifier
         .height(16.dp))

    Text(text = stringResource(id = R.string.coming_soon),
        fontSize = 36.sp)

        Spacer(modifier = Modifier
            .height(16.dp))

        Button(onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.medium_blue)
            ),
            shape = RoundedCornerShape(12.dp),
            modifier =
            Modifier
                .fillMaxWidth(.8f)) {
            Text(text = stringResource(id = R.string.refresh),
                modifier = Modifier.padding(8.dp))
        }
    }
}