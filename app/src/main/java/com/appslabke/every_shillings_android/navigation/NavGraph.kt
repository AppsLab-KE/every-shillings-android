package com.appslabke.every_shillings_android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appslabke.every_shillings_android.ui.Login
import com.appslabke.every_shillings_android.ui.Signup
import com.appslabke.every_shillings_android.ui.VerifySignUp
import com.appslabke.every_shillings_android.ui.screens.ExchangeCurrency
import com.appslabke.every_shillings_android.ui.screens.HomeScreen
import com.appslabke.every_shillings_android.ui.screens.LoginOtp
import com.appslabke.every_shillings_android.ui.screens.OnboadingScreen
import com.appslabke.every_shillings_android.ui.screens.TopupScreen

/*
* We used Extension Functions for every Screen referencing NavGraphBuilder object
*/

@Composable
fun SetNavGraph(
    startDestination: String,
    navController: NavHostController,

) {

    NavHost(
        startDestination = startDestination,
        navController = navController
    ){
        // call Extension functions of NavGraphBuilder

        home(
            exchangeCurr = {
                navController.navigate(Screens.ExchangeScreen.route)
            },
            navController = navController
        )
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
            },
            navigateToLoginScreen = {
                navController.navigate(Screens.Login.route)
            }
        )
        login(
            navigateLoginOtp ={
                navController.navigate(Screens.LoginOtpScreen.route)
            }
        )
        verifySignup(
            toHomeScreen = {
                navController.navigate(Screens.Home.route)
            },
            navigateBack = {
                navController.popBackStack()
            },
        )

        loginOtp(
            navigateToHome ={
                navController.navigate(Screens.Home.route)
            }
        )
        ExchangeScreen(
            toTopupScreen = {
                navController.navigate(Screens.TopUpScreen.route)
            }
        )
//        Sell()
        topUpAccount()
    }

}

//Home
fun NavGraphBuilder.home(
    exchangeCurr: () -> Unit,
    navController : NavController
){
    composable(route = Screens.Home.route){
        // call home composable here
        HomeScreen(
            toexchangeCurr = exchangeCurr,
            navController = navController
        )
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
    navigateSignUpOtp : () -> Unit,
    navigateToLoginScreen: () -> Unit,
){
    composable(route = Screens.SignUp.route){
        // call SignUp composable here
        Signup(
            navigateToVerifySignUpOtpScreen =navigateSignUpOtp,
            navigateToLoginScreen = navigateToLoginScreen
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
fun NavGraphBuilder.verifySignup(
    toHomeScreen: () -> Unit,
    navigateBack: () -> Unit
){
    composable(route = Screens.SignUpOtpScreen.route){
        // call Login composable here
        VerifySignUp(
            toHomeScreen = { toHomeScreen() },
            navigateBack = { navigateBack() }
        )
    }
}

//LoginOtp Screen
fun NavGraphBuilder.loginOtp(
    navigateToHome: ()-> Unit
){
    composable(route = Screens.LoginOtpScreen.route){
        // call Login composable here
        LoginOtp(
            navigatetoHome = { navigateToHome() }
        )
    }
}

//Home
fun NavGraphBuilder.topUpAccount(){
    composable(route = Screens.TopUpScreen.route){
        // call home composable here
        TopupScreen()

    }
}

// ExchangeScreen

fun NavGraphBuilder.ExchangeScreen(
    toTopupScreen: () -> Unit
){
    composable(route = Screens.ExchangeScreen.route){
        // call ExchangeScreen composable here
        ExchangeCurrency(
            toTopupScreen = toTopupScreen
        )
    }
}

//fun NavGraphBuilder.Sell(){
//    composable(route = Screens.Sell.route){
//        // call ExchangeScreen composable here
//        ExchangeCurrency()
//    }
//}

