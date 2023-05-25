package com.appslabke.every_shillings_android.navigation

import android.util.Log
import android.widget.Toast
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.appslabke.every_shillings_android.MainActivity

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
                icon = { Icon(painterResource(id = item.icon!!), contentDescription = item.title) },
                label = { Text(text = item.title!!) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {}
            )


        }

    }
}