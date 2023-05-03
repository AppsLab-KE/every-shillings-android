package com.appslabke.every_shillings_android.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R

//import com.appslabke.every_shillings_android.ui.screens.validateCode

import com.togitech.ccp.component.*
import com.togitech.ccp.data.utils.getLibCountries

@Composable
fun Login(
    navigateToLoginOtpScreen: () -> Unit,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val focusManager = LocalFocusManager.current
        val phoneCode = rememberSaveable { mutableStateOf("+254") }
        val phoneNumberValid = remember { mutableStateOf(true) }
        val phoneNumber = remember { mutableStateOf("") }
        val fullPhoneNumber = remember { mutableStateOf("") }
        val onlyPhoneNumber = remember { mutableStateOf("") }

        Text(
            text = "Login",
            color = Color(0xFF2B5EC0),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
            modifier = Modifier.padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Enter your phone number",
            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "We will send you the six digit verification code",
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Phone Number",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    bottom = 14.dp
                )
        )
        Column {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                value = phoneNumber.value,
                onValueChange = { phoneNo ->
                    phoneNumber.value = phoneNo
                    fullPhoneNumber.value = phoneCode.value + phoneNumber.value
                    phoneNumberValid.value = true
                },
                leadingIcon = {
                    TogiCodeDialog(
                        defaultSelectedCountry = getLibCountries.first { countryData -> countryData.countryPhoneCode == "+254" },
                        pickedCountry = { getLibCountries.first { data -> data.countryPhoneCode == "+254" } }
                    )
                },
                trailingIcon = {
                    if (phoneNumber.value.isNotEmpty()) {
                        IconButton(onClick = {
                            phoneNumber.value = ""
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "Clear",
                            )
                        }
                    }
                },
                placeholder = {
                    Text(
                        text = "712345678",
                        fontFamily = FontFamily(Font(R.font.urbanist_regular))
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Phone
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                isError = !phoneNumberValid.value
            )

            if (!phoneNumberValid.value) {
                Text(
                    text = "Enter a valid phone number",
                    color = MaterialTheme.colors.error,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp, start = 22.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {

                phoneNumberValid.value = validatePhoneNumber(inputNumber = phoneNumber.value)

                if (phoneNumberValid.value) {
                    // Verify Otp
                    Log.i("Valid Number", "It's valid ${fullPhoneNumber.value}")
                    fullPhoneNumber.value = getFullPhoneNumber()
                    onlyPhoneNumber.value = getOnlyPhoneNumber()

                    navigateToLoginOtpScreen.invoke()


                } else if (!phoneNumberValid.value) {
                    Log.i("Valid Number", "Phone number not valid")
                    fullPhoneNumber.value = "Error"
                    onlyPhoneNumber.value = "Error"
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF2B5EC0),
                contentColor = Color.White
            )
        ) {
            Text(text = "Generate OTP",
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 16.sp,
                modifier = Modifier.clickable { navigateToLoginOtpScreen() })
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = "Sign up",
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 16.sp,
                color = Color(0xFF2B5EC0),
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable {
                    /*TODO()*/
                }
            )
        }
    }
}

fun validatePhoneNumber(inputNumber: String): Boolean {
    return inputNumber.length == 9
}

