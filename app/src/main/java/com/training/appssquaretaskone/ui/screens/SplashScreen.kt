package com.training.appssquaretaskone.ui.screens

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.training.appssquaretaskone.R
import com.training.appssquaretaskone.utils.DestinationUtils

@Composable
fun SplashScreen(navController:NavHostController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        val (splashImage,aspenText,planText,vacationText, exploreButton) = createRefs()
        Image(painter = painterResource(id = R.drawable.splash_bg),
            contentDescription = "splash image",
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(splashImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Crop
        )

        Text(text = stringResource(id = R.string.aspen_text),
            color = Color.White,
            fontSize = 116.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(400),
            modifier = Modifier
                .constrainAs(aspenText){
                    top.linkTo(parent.top, margin = 107.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        Text(text = stringResource(id = R.string.plan_text),
            color = Color.White,
            fontSize = 27.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier
                .constrainAs(planText){
                    start.linkTo(vacationText.start)
                    bottom.linkTo(vacationText.top)
                })

        Text(text = stringResource(id = R.string.luxurious_text),
            color = Color.White,
            fontSize = 47.sp,
            textAlign = TextAlign.Start,
            lineHeight = 53.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier
                .fillMaxWidth(fraction = .8f)
                .constrainAs(vacationText) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(exploreButton.top, margin = 20.dp)
                })

        Button(onClick = {
            navController.navigate(DestinationUtils.REGISTER_SCREEN)
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.medium_blue)
            ),
            shape = RoundedCornerShape(12.dp),
            modifier =
            Modifier
                .fillMaxWidth(.8f)
                .constrainAs(exploreButton) {
                    bottom.linkTo(parent.bottom, margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Text(text = "Explore",
                modifier = Modifier.padding(8.dp))
        }
    }
}
