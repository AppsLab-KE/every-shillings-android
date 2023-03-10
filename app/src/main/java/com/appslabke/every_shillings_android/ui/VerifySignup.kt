package com.appslabke.every_shillings_android.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.ui.theme.EveryshillingsandroidTheme

@Composable
fun VerifySignup(modifier: Modifier = Modifier) {
    val code = rememberSaveable{ mutableStateOf("")  }
    val focusRequester = remember{ FocusRequester()  }
    val focusManager = LocalFocusManager.current
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier
            .fillMaxWidth()
            .padding(PaddingValues(20.dp))
            .pointerInput(Unit) {
                detectTapGestures {
                    focusManager.clearFocus()
                }
            } ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign Up",
                color = Color(0xFF2B5EC0),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = modifier.height(30.dp))
            Text(
                text = "Verify your phone number",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = "Enter the four digit code sent to your number",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 70.dp)
                    .focusRequester(focusRequester),
                value = code.value,
                onValueChange = { code.value = it },
                textStyle = TextStyle.Default.copy(fontSize = 20.sp),
                label = { Text(text = "Code")},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color(0xFF2B5EC0),
                    cursorColor = Color(0xFF2B5EC0),
                    backgroundColor = Color.Transparent,
                    focusedLabelColor = Color(0xFF2B5EC0),
                ),
            )
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Didn't receive the code?",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
                Spacer(modifier = modifier.width(2.dp))
                Text(
                    text = "Click here to resend",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color(0xFF2B5EC0),
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    modifier = modifier.clickable {
                        /*TODO()*/
                    }
                )
            }
            Spacer(modifier = modifier.height(30.dp))
            Button(
                onClick = {
                    focusManager.clearFocus()
                    /*TODO()*/
                },
                modifier = modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF2B5EC0),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Continue", fontSize = 18.sp)
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun VerifySignupPreview() {
    EveryshillingsandroidTheme {
        VerifySignup()
    }
}