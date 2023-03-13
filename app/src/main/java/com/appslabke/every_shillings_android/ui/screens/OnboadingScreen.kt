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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnboadingScreen() {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 147.dp),
            contentAlignment = Alignment.Center,
        ) {
            Box(modifier = Modifier.align(Alignment.TopStart)){
                Column(modifier = Modifier.fillMaxWidth().wrapContentSize(align = Alignment.Center)) {
                    Image(painter =
                    painterResource(id = R.drawable.dummy_logo),
                        contentDescription = "",
                        modifier = Modifier.size(115.dp, 160.dp))
                    Spacer(modifier = Modifier.height(138.dp) )
                }
            }
            Box(modifier = Modifier
                .padding(vertical = 15.dp)
                .align(Alignment.Center),
            ){
                Column() {
                    Text(text = "Welcome to Everyshillingi", modifier = Modifier
                        .fillMaxWidth(), textAlign = TextAlign.Center,
                        fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(20.dp) )
                    Text(text = "Exchange made easy, anywhere.", modifier = Modifier
                        .fillMaxWidth(),textAlign = TextAlign.Center, fontSize = 14.sp)
                }
            }
            Box(modifier = Modifier.align(Alignment.BottomCenter)){
                Column(modifier = Modifier) {

                    // Sign up
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = MaterialTheme.shapes.medium,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFF2B5EC0)
                        )

                    ) {
                        Text(text = "Sign up")
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    // Sign in
                    OutlinedButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = MaterialTheme.shapes.medium,
                        border = BorderStroke(1.dp, color = Color(0xFF2B5EC0))
                    ) {
                        Text(text = "Sign in")
                    }
                }

            }
        }
    }
}