package com.training.appssquaretaskone.ui.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.training.appssquaretaskone.R
import com.training.appssquaretaskone.model.City
import com.training.appssquaretaskone.viewmodel.CitiesViewModel


@Composable
fun CitiesScreen(context:Context,
                 onItemClick:()->Unit,
                 navController:NavHostController){
        var citeisViewModel = CitiesViewModel(context)
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier =
            Modifier
                .fillMaxWidth()
                .height(33.47.dp))
            
            Image(painter = painterResource(id = R.drawable.sign_up_image),
                contentDescription ="image",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(width = 135.9.dp, height = 116.88.dp))

            Spacer(modifier = Modifier
                .height(50.dp)
                .fillMaxWidth())

            Text(text = stringResource(id = R.string.popular_cities),
                fontSize = 26.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
                    .align(alignment = Alignment.Start)
            )

            LazyColumn(content = {
                items(items = citeisViewModel.getCities()){
                    ListItem(item = it, onItemClick)
                }
            })
        }
}

@Composable
fun ListItem(item: City, onItemClick: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .padding(start = 16.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick()
            }
    ) {
        val (cityImage, cityName, cityReview) = createRefs()
        Image(painter = painterResource(id = item.image),
            contentDescription ="city image",
            modifier = Modifier
                .size(210.dp, 177.dp)
                .shadow(elevation = 10.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .constrainAs(cityImage) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }
            )

        Text(text = item.name,
            modifier = Modifier
                .constrainAs(cityName){
                    start.linkTo(cityImage.end, margin = 16.dp)
                    top.linkTo(cityImage.top)
                    bottom.linkTo(cityImage.bottom)
                })
        Text(text = item.reviews,
            color = colorResource(id = R.color.medium_blue),
            modifier= Modifier
                .constrainAs(cityReview){
                    start.linkTo(cityName.start)
                    end.linkTo(cityName.end)
                    top.linkTo(cityName.bottom)
                })

    }
}