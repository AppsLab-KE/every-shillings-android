package com.appslabke.every_shillings_android.navigation


import com.appslabke.every_shillings_android.R

sealed class Screens (val route: String, val icon: Int?, val title: String?){
    object Home: Screens(route = "Home", icon = R.drawable.outline_home_24, title = "Home")
    object OnboardingScreen: Screens(route = "OnboardingScreen", icon = null, title = null)
    object SignUp: Screens(route = "SignUp", icon = null, title = null)
    object ForgetPassword: Screens(route = "ForgetPassword", icon = null, title = null)
    object Login: Screens(route = "Login", icon = null, title = null)
    object LoginOtpScreen: Screens(route = "LoginOtpScreen", icon = null, title = null)
    object SignUpOtpScreen: Screens(route = "SignUpOtpScreen", icon = null, title = null)
    object TopUpScreen: Screens(route = "TopUpScreen", icon = null, title = null)
    object ExchangeScreen: Screens(route = "ExchangeScreen", icon = R.drawable.outline_attach_money_24, title = "Buy")
    object Marketplace: Screens(route = "Marketplace", icon = R.drawable.outline_shopping_bag_24, title = "MarketPlace")
    object Sell: Screens(route = "Sell", icon = R.drawable.outline_sell_24, title = "Sell")
}