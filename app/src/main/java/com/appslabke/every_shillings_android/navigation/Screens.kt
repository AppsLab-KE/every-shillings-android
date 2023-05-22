package com.appslabke.every_shillings_android.navigation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import com.appslabke.every_shillings_android.R

sealed class Screens (val route: String, val icon: Int?){
    object Home: Screens(route = "Home", icon = R.drawable.outline_home_24)
    object OnboardingScreen: Screens(route = "OnboardingScreen", icon = null)
    object SignUp: Screens(route = "SignUp", icon = null)
    object Login: Screens(route = "Login", icon = null)
    object LoginOtpScreen: Screens(route = "LoginOtpScreen", icon = null)
    object SignUpOtpScreen: Screens(route = "SignUpOtpScreen", icon = null)
    object TopUpScreen: Screens(route = "TopUpScreen", icon = null)
    object ExchangeScreen: Screens(route = "ExchangeScreen", icon = R.drawable.outline_attach_money_24)
    object Marketplace: Screens(route = "Marketplace", icon = R.drawable.outline_shopping_bag_24)
    object Sell: Screens(route = "Sell", icon = R.drawable.outline_sell_24)
}