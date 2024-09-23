package com.training.appssquaretaskone.extensions

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.training.appssquaretaskone.ui.screens.CitiesScreen
import com.training.appssquaretaskone.ui.screens.CityDetailsScreen
import com.training.appssquaretaskone.ui.screens.LoginScreen
import com.training.appssquaretaskone.ui.screens.SignUpScreen
import com.training.appssquaretaskone.ui.screens.SplashScreen
import com.training.appssquaretaskone.utils.DestinationUtils
import com.training.appssquaretaskone.viewmodel.LoginViewModel
import com.training.appssquaretaskone.viewmodel.RegisterViewModel

@Composable
fun Context.navHost(
    navController: NavHostController,
    registerViewModel:RegisterViewModel,
    loginViewModel:LoginViewModel){

    NavHost(navController = navController,
        startDestination = DestinationUtils.SPLASH_SCREEN){
        composable(DestinationUtils.SPLASH_SCREEN){
            SplashScreen(navController)
        }

        composable(DestinationUtils.REGISTER_SCREEN){
            SignUpScreen(navController = navController,
                registerViewModel)
        }

        composable(DestinationUtils.LOGIN_SCREEN){
            LoginScreen(navController = navController, loginViewModel)
        }

        composable(DestinationUtils.CITIES_SCREEN){
            CitiesScreen(context = applicationContext,
                onItemClick = {
                    navController
                        .navigate(DestinationUtils.CITY_DETAILS_SCREEN)
                },
                navController =navController )
        }

        composable(DestinationUtils.CITY_DETAILS_SCREEN){
            CityDetailsScreen(navController = navController)
        }
    }
}