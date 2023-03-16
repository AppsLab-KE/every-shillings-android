package com.appslabke.every_shillings_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.appslabke.every_shillings_android.navigation.Screens
import com.appslabke.every_shillings_android.navigation.SetNavGraph
import com.appslabke.every_shillings_android.ui.theme.EveryshillingsandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EveryshillingsandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    SetNavGraph(startDestination = Screens.OnboardingScreen.route,
                        navController = navController)
                }
            }
        }
    }
}

@Composable
fun Home() {
    Text(text = "Hello Screen")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EveryshillingsandroidTheme {
        Home()
    }
}
