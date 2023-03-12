package com.appslabke.every_shillings_android.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R

// Login Otp Verification
@Preview
@Composable
fun LoginOtp() {

    val context = LocalContext.current

    val otpCode = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {

            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Login",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Color(0xFF2B5EC0),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            
            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Verify Your Phone Number",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(text = "Enter the 4 digit code sent to your number",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(45.dp))

            OutlinedTextField(
                value = otpCode.value,
                onValueChange = {otpCode.value = it},
                label = { Text(text = "Code") },
                textStyle = TextStyle(fontFamily = FontFamily(Font(R.font.poppins_regular))),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                singleLine = true,
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Go)
            )

            Spacer(modifier = Modifier.height(45.dp))
            
            Row {
                Text(text = "Didn't receive a code?",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = "Click here to resend",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        textDecoration = TextDecoration.Underline,
                        fontSize = 15.sp,
                        color = Color(0xFF2B5EC0)
                    ),
                    modifier = Modifier.clickable {
                        // TODO
                    }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if(otpCode.value.isNotEmpty() && otpCode.value.length == 4) {
                        // TODO
                    } else {
                        Toast.makeText(context,
                            "Kindly enter a valid code", Toast.LENGTH_SHORT).show()
                    }
                },
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF2B5EC0),
                    contentColor = Color.White),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 3.dp,
                    pressedElevation = 0.dp, )) {
                Text(text = "Continue",
                    style = TextStyle (
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                        ))}
        }
    }
}