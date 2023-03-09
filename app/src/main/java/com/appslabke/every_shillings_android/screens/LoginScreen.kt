package com.appslabke.every_shillings_android.screens

import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
        ) {

        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Enter Your Phone Number",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
            )
            Text(text = "We will send you the 4 digit verification code",
                style = TextStyle(
                    color = Color.Black
                )
            )

            var phoneNumber = remember {
                mutableStateOf("")
            }

            OutlinedTextField(value = phoneNumber.value,
                onValueChange = {phoneNumber.value = it})
            
            Button(onClick = {  }) {
                Text(text = "Generate OTP")
            }

            Text(text = "Do you have an account? Signup",
                style = TextStyle(
                    color = Color.Black
                )
            )

        }

    }
}