package com.appslabke.every_shillings_android.ui

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.togitech.ccp.component.*
import com.togitech.ccp.data.utils.getLibCountries

@Composable
fun Login(
    navigateToLoginOtpScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val focusManager = LocalFocusManager.current
        val phoneCode = rememberSaveable { mutableStateOf("+254") }
        val phoneNumberInvalid = rememberSaveable { mutableStateOf(false) }
        val phoneNumber = rememberSaveable { mutableStateOf("") }
        val fullPhoneNumber = rememberSaveable { mutableStateOf("") }
        val onlyPhoneNumber = rememberSaveable { mutableStateOf("") }

        Text(
            text = "Login",
            color = Color(0xFF2B5EC0),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Enter your phone number",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "We will send you the four digit verification code",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Phone Number",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    bottom = 14.dp
                )
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            value = phoneNumber.value,
            onValueChange = {
                phoneNumber.value = it
                fullPhoneNumber.value = phoneCode.value + phoneNumber.value
                if (phoneNumber.value.length == 9) phoneNumberInvalid.value = false
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
            placeholder = { Text(text = "712345678") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Phone
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            isError = phoneNumberInvalid.value
        )
        if (phoneNumberInvalid.value) {
            Text(
                text = "Enter a valid phone number",
                color = MaterialTheme.colors.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                if (!isPhoneNumber()) {
                    fullPhoneNumber.value = getFullPhoneNumber()
                    onlyPhoneNumber.value = getOnlyPhoneNumber()
                } else {
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
            Text(text = "Generate OTP", fontSize = 16.sp, modifier = Modifier.clickable { navigateToLoginOtpScreen() })
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
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = "Sign up",
                fontWeight = FontWeight.Normal,
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

