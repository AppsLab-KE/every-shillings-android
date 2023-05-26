package com.appslabke.every_shillings_android.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R
import com.appslabke.every_shillings_android.destinations.LoginDestination
import com.appslabke.every_shillings_android.destinations.SignupDestination
import com.datadog.android.compose.ExperimentalTrackingApi
import com.datadog.android.compose.trackClick
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination

@OptIn(ExperimentalTrackingApi::class)
@Composable
fun OnboadingScreen(
   navigator: DestinationsNavigator
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 33.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
            ) {
                Image(
                    painter =
                    painterResource(id = R.drawable.dummy_logo),
                    contentDescription = "",
                    modifier = Modifier.size(115.dp, 160.dp)
                )

            }

            Column() {
                Text(text = "Welcome to Everyshilling", modifier = Modifier
                    .fillMaxWidth(),  textAlign = TextAlign.Center,
                    fontSize = 24.sp, fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular))
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Exchange made easy, anywhere.", modifier = Modifier
                    .fillMaxWidth(),
                    textAlign = TextAlign.Center, fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular))
                )
            }

            Column(modifier = Modifier) {

                // Sign up
                Button(
                    onClick = trackClick(targetName = "Signup") { navigator.navigate(SignupDestination) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF2B5EC0)
                    )

                ) {
                    Text(text = "Sign up", fontFamily = FontFamily(Font(R.font.urbanist_regular)))
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Sign in
                OutlinedButton(
                    onClick = trackClick(targetName = "Login") { navigator.navigate(LoginDestination)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = MaterialTheme.shapes.medium,
                    border = BorderStroke(1.dp, color = Color(0xFF2B5EC0))
                ) {
                    Text(text = "Sign in", fontFamily = FontFamily(Font(R.font.urbanist_regular)))
                }
            }

        }
    }
}