package com.appslabke.every_shillings_android.navigation

import Login
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appslabke.every_shillings_android.ui.Signup
import com.appslabke.every_shillings_android.ui.VerifySignup
import com.appslabke.every_shillings_android.ui.screens.LoginOtp
import com.appslabke.every_shillings_android.ui.screens.OnboadingScreen

/*
* We used Extension Functions for every Screen referencing NavGraphBuilder object
*/

@Composable
fun SetNavGraph(
    startDestination: String,
    navController: NavHostController
) {

    NavHost(
        startDestination = startDestination,
        navController = navController
    ){
        // call Extension functions of NavGraphBuilder
        onboardingScreen(
            navigateToLogin = {
                navController.navigate(Screens.Login.route)
            },
            navigateToSignUp = {
                navController.navigate(Screens.SignUp.route)
            }
        )
        signup(
            navigateSignUpOtp ={
                navController.navigate(Screens.SignUpOtpScreen.route)
            }
        )
        login(
            navigateLoginOtp ={
                navController.navigate(Screens.LoginOtpScreen.route)
            }
        )
        verifySignup()
        loginOtp()
    }

}

//OnboardingScreen
fun NavGraphBuilder.onboardingScreen(
    navigateToLogin: () -> Unit,
    navigateToSignUp : () -> Unit
){
    composable(route = Screens.OnboardingScreen.route){
        // call OnboardingScreen composable here
        OnboadingScreen(
            navigateToLoginScreen = navigateToLogin,
            navigateToSigUpScreen = navigateToSignUp
        )
    }
}

//Signup Screen
fun NavGraphBuilder.signup(
    navigateSignUpOtp : () -> Unit
){
    composable(route = Screens.SignUp.route){
        // call SignUp composable here
        Signup(
            navigateToVerifySignUpOtpScreen =navigateSignUpOtp
        )
    }
}

//Login Screen
fun NavGraphBuilder.login(
    navigateLoginOtp: () -> Unit
){
    composable(route = Screens.Login.route){
        // call Login composable here
        Login(
            navigateToLoginOtpScreen = navigateLoginOtp
        )
    }
}

//VerifySignup Screen
fun NavGraphBuilder.verifySignup(){
    composable(route = Screens.SignUpOtpScreen.route){
        // call Login composable here
        VerifySignup()
    }
}

//LoginOtp Screen
fun NavGraphBuilder.loginOtp(){
    composable(route = Screens.LoginOtpScreen.route){
        // call Login composable here
        LoginOtp()
    }
}