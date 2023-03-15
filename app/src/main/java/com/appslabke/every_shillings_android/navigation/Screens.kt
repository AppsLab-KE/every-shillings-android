package com.appslabke.every_shillings_android.navigation

sealed class Screens (val route: String){
    object OnboardingScreen: Screens(route = "OnboardingScreen")
    object SignUp: Screens(route = "SignUp")
    object Login: Screens(route = "Login")
    object LoginOtpScreen: Screens(route = "LoginOtpScreen")
    object SignUpOtpScreen: Screens(route = "SignUpOtpScreen")
}