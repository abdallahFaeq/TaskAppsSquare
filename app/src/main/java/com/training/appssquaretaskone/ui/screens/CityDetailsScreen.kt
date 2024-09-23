package com.training.appssquaretaskone.ui.screens

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.training.appssquaretaskone.R

@Composable
fun CityDetailsScreen(
    navController:NavHostController
){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var startGuideLine = createGuidelineFromStart(fraction = .05f)
        var endGuideLine = createGuidelineFromEnd(fraction = .05f)

        val (boxBackButton, backButton, cityImage, cityName, cityReviews, cityDescription) = createRefs()
        Box(modifier = Modifier
            .size(44.dp, 42.dp)
            .clip(RoundedCornerShape(8.dp))
            .constrainAs(boxBackButton) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(startGuideLine)
            }){
            IconButton(modifier = Modifier
                .background(color = colorResource(id = R.color.medium_blue)),
                onClick = {

            }){
                Icon(imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription ="",
                    tint = Color.White
                )
            }
        }
        Image(painter = painterResource(id = R.drawable.germany),
            contentDescription ="",
            modifier = Modifier
                .height(267.dp)
                .constrainAs(cityImage) {
                    start.linkTo(startGuideLine)
                    end.linkTo(endGuideLine)
                    top.linkTo(boxBackButton.bottom, margin = 16.dp)
                    width = Dimension.fillToConstraints
                },
            contentScale = ContentScale.Crop)

        Text(text = stringResource(id = R.string.cities_name),
            modifier = Modifier
                .constrainAs(cityName){
                    start.linkTo(startGuideLine)
                    top.linkTo(cityImage.bottom, margin = 16.dp)
                })

        Text(text = stringResource(id = R.string.cities_reviews),
            color = colorResource(id = R.color.medium_blue),
            modifier = Modifier
                .constrainAs(cityReviews){
                    end.linkTo(endGuideLine)
                    top.linkTo(cityImage.bottom, margin = 16.dp)
                })

        Text(text = stringResource(id = R.string.description),
            textAlign = TextAlign.Start,
            modifier = Modifier
                .constrainAs(cityDescription){
                    top.linkTo(cityName.bottom, margin = 16.dp)
                    start.linkTo(startGuideLine)
                    end.linkTo(endGuideLine)
                    width = Dimension.fillToConstraints
                })
    }
}