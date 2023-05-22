package com.appslabke.every_shillings_android.navigation

sealed class Screens (val route: String){
    object Home: Screens(route = "Home")
    object OnboardingScreen: Screens(route = "OnboardingScreen")
    object SignUp: Screens(route = "SignUp")
    object Login: Screens(route = "Login")
    object LoginOtpScreen: Screens(route = "LoginOtpScreen")
    object SignUpOtpScreen: Screens(route = "SignUpOtpScreen")
    object TopUpScreen: Screens(route = "TopUpScreen")
    object ExchangeScreen: Screens(route = "ExchangeScreen")
    object Marketplace: Screens(route = "Marketplace")
}