package com.appslabke.every_shillings_android.navigation

import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.appslabke.every_shillings_android.destinations.ExchangeCurrencyDestination
import com.appslabke.every_shillings_android.destinations.HomeScreenDestination
import com.appslabke.every_shillings_android.destinations.MarketPlaceDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun BottomNavigationBar(

    navigator: DestinationsNavigator
) {
    val items = listOf(
        Screens.Home,
        Screens.Marketplace,
        Screens.ExchangeScreen,
        Screens.Sell
    )

    BottomNavigation (
        backgroundColor = Color(0xFF2B5EC0),
        contentColor = Color.White
    ){
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {item ->
            if(item.route == "Home"){
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = item.icon!!), contentDescription = item.title) },
                    label = { Text(text = item.title!!) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = true,
                    onClick = {
                        navigator.navigate(HomeScreenDestination)
                    }
                )
            }
            else if(item.route == "Marketplace"){
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = item.icon!!), contentDescription = item.title) },
                    label = { Text(text = item.title!!) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = true,
                    onClick = {
                        navigator.navigate(MarketPlaceDestination)
                    }
                )
            }

            else if(item.route == "Sell"){
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = item.icon!!), contentDescription = item.title) },
                    label = { Text(text = item.title!!) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = true,
                    onClick = {
                        Log.i("Tag", "BottomNavigationBar: Sell")
                    }
                )
            }

            else if(item.route == "ExchangeScreen"){
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = item.icon!!), contentDescription = item.title) },
                    label = { Text(text = item.title!!) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = true,
                    onClick = {
                        navigator.navigate(ExchangeCurrencyDestination)
                    }
                )
            }



        }

    }
}