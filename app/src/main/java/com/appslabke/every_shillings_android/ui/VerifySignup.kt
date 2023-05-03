package com.appslabke.every_shillings_android.ui

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R
import com.appslabke.every_shillings_android.ui.theme.EveryshillingsandroidTheme
import com.datadog.android.compose.ExperimentalTrackingApi
import com.datadog.android.compose.trackClick


@OptIn(ExperimentalTrackingApi::class)
@Composable
fun VerifySignup(
    modifier: Modifier = Modifier,
    toHomeScreen: () -> Unit,
    navigateBack: () -> Unit
) {
    val code = rememberSaveable { mutableStateOf("") }
    val otpCode = rememberSaveable { mutableStateOf("") }
    val codeIsInvalid = rememberSaveable { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()

    val otpVal = remember {
        mutableStateOf("")
    }
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(PaddingValues(20.dp))
                .verticalScroll(scrollState)
                .pointerInput(Unit) {
                    detectTapGestures {
                        focusManager.clearFocus()
                    }
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier.fillMaxWidth()
            ) {
                // Spacer(modifier = modifier.width(10.dp))
                Text(
                    text = "Sign Up",
                    color = MaterialTheme.colors.primary,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = modifier.align(Alignment.Center)
                )
                IconButton(
                    modifier = modifier.align(Alignment.CenterStart),
                    onClick = {
                        navigateBack()
                    }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go back")
                }
            }

            Spacer(modifier = modifier.height(30.dp))
            Text(
                text = "Verify your phone number",

                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = "Enter six digit code sent to your number",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,

                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 18.sp,
                modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier = modifier.height(70.dp))
            BasicTextField(
                value = otpCode.value,
                onValueChange = {
                    if (it.length <= 4) {
                        otpCode.value = it
                    }
                    if (otpCode.value.length == 4) {
                        focusManager.clearFocus()
                        codeIsInvalid.value = false
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword
                ),
                decorationBox = {
                    Row(horizontalArrangement = Arrangement.Center) {
                        repeat(4) { index ->
                            val numChar = when {
                                index >= otpCode.value.length -> ""
                                else -> otpCode.value[index].toString()
                            }
                            val isFocused = otpCode.value.length == index
                            Text(
                                modifier = Modifier
                                    .width(45.dp)
                                    .height(45.dp)
                                    .border(
                                        width = if (isFocused) 2.dp else 1.dp,
                                        color = if (isFocused) MaterialTheme.colors.primary else Color.Gray,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(2.dp),
                                text = numChar,
                                color = MaterialTheme.colors.onBackground,
                                style = MaterialTheme.typography.h4,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }
                }
            )

            /* Column() {
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(top = 50.dp),
                     horizontalArrangement = Arrangement.SpaceEvenly
                 ) {
                     CommonOtpTextField(otp = otpVal)
                     CommonOtpTextField(otp = otpVal)
                     CommonOtpTextField(otp = otpVal)
                     CommonOtpTextField(otp = otpVal)
                     CommonOtpTextField(otp = otpVal)
                     CommonOtpTextField(otp = otpVal)
                 }
             }*/
//            OutlinedTextField(
//                modifier = modifier
//                    .fillMaxWidth()
//                    .padding(top = 70.dp)
//                    .focusRequester(focusRequester),
//                value = code.value,
//                onValueChange = {
//                    code.value = it
//                    if (code.value.length == 4) {
//                        focusManager.clearFocus()
//                        codeIsInvalid.value = false
//                    }
//                },
//                textStyle = TextStyle.Default.copy(fontSize = 20.sp),
//                label = { Text(text = "Code") },
//                keyboardOptions = KeyboardOptions(
//                    keyboardType = KeyboardType.Number,
//                    imeAction = ImeAction.Done
//                ),
//                keyboardActions = KeyboardActions(
//                    onDone = { focusManager.clearFocus() }
//                ),
//                isError = codeIsInvalid.value
//            )
//            if (codeIsInvalid.value) {
//                Text(
//                    text = "Enter a valid code",
//                    color = MaterialTheme.colors.error,
//
//                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
//                    modifier = modifier
//                        .fillMaxWidth()
//                        .padding(top = 10.dp)
//                )
//            }
            Spacer(modifier = modifier.height(70.dp))

            AnnotatedResendCodeText()
            Spacer(modifier = modifier.height(30.dp))
            Button(
                onClick = trackClick(targetName = "Verify OTP") {
                    toHomeScreen()
                    if (code.value.length != 4) {
                        codeIsInvalid.value = true
                    } else {
                        codeIsInvalid.value = false
                        focusManager.clearFocus()

                    }
                },
                modifier = modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text(text = "Continue",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)))
            }

        }
    }
}

@Composable
fun AnnotatedResendCodeText() {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        append("Didn't receive the code? ")
        pushStringAnnotation(
            tag = "resend_code",
            annotation = "Do resend code"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary
            )
        ) {
            append("Click here to resend")
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        style = TextStyle.Default.copy(fontSize = 18.sp),
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "resend_code",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                Toast.makeText(context, "TODO() resend code", Toast.LENGTH_SHORT).show()
                /*TODO()*/
            }
        })
}

@Preview(showSystemUi = true)
@Composable
fun VerifySignupPreview() {
    EveryshillingsandroidTheme {
        VerifySignup(
            toHomeScreen = {},
            navigateBack = {}
        )
    }
}