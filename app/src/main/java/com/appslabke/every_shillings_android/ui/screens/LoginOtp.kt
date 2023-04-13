package com.appslabke.every_shillings_android.ui.screens

import android.util.Log
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
@Composable
fun LoginOtp(
    navigatetoHome: () -> Unit,
) {

    val context = LocalContext.current

    val otpCode = remember {
        mutableStateOf("")
    }

    val isOtpValid = remember {
        mutableStateOf(true)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Login",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    color = Color(0xFF2B5EC0),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Verify Your Phone Number",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Enter the 4 digit code sent to your number",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(45.dp))

            Column {

                OutlinedTextField(
                    value = otpCode.value,
                    onValueChange = { otp ->
                        otpCode.value = otp
                        isOtpValid.value = true
                    },
                    placeholder = { Text(text = "1234") },
                    textStyle = TextStyle(fontFamily = FontFamily(Font(R.font.urbanist_regular))),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    singleLine = true,
                    maxLines = 1,
                    isError = !isOtpValid.value,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF2B5EC0),
                        cursorColor = Color(0xFF2B5EC0)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Go
                    )
                )

                if (!isOtpValid.value) {
                    Text(
                        modifier = Modifier.padding(start = 22.dp, top = 2.dp),
                        text = "Kindly enter a valid 4 digit Otp",
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.error
                    )
                }
            }

            Spacer(modifier = Modifier.height(45.dp))

            Row {
                Text(
                    text = "Didn't receive a code?",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = "Click here to resend",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
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
                    isOtpValid.value = validateCode(inputCode = otpCode.value)

                    if (isOtpValid.value) {
                        // Verify Otp
                        Log.i("Code Valid", " - ${isOtpValid.value}")
                        Toast.makeText(
                            context,
                            "Valid - ${isOtpValid.value}", Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF2B5EC0),
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 3.dp,
                    pressedElevation = 0.dp,
                )
            ) {
                Text(
                    text = "Continue",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                )
            }
        }
    }
}

fun validateCode(inputCode: String): Boolean {
    return inputCode.length == 4
}