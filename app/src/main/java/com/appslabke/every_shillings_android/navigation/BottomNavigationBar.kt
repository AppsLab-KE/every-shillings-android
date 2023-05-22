package com.appslabke.every_shillings_android.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
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
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {item ->
            BottomNavigationItem(
               icon = { Icon(painter = painterResource(id = ), contentDescription = "icons")},
                label = { Text (text = "")},
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(route){

                            }
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
        }
    }
}