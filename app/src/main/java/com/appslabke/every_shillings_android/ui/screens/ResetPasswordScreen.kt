package com.appslabke.every_shillings_android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R


@Preview
@Composable
fun ResetPasswordScreen() {

    var newPassword  by remember {
        mutableStateOf("")
    }

    var showPassword:Boolean by remember {
        mutableStateOf(false)
    }

    var confirmPassword  by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 50.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            text = "Reset password"
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            text = "Enter your email address"
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp),
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontWeight = FontWeight.Normal,
            text = "New password"
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .height(56.dp),
            value = newPassword,
            onValueChange = {
                newPassword = it
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword}) {
                   Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Lock password")
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp),
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontWeight = FontWeight.Normal,
            text = "Confirm password"
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .height(56.dp),
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                confirmPassword = newPassword
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword}) {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Lock password")
                }
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF2B5EC0),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Continue",
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 16.sp
            )
         }

    }
}