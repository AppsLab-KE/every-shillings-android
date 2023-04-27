package com.appslabke.every_shillings_android.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R
import kotlinx.coroutines.delay

// Login Otp Verification
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginOtp(
    navigatetoHome: () -> Unit,
) {

    val otpCode = remember {
        mutableStateOf("")
    }

    val isOtpValid = remember {
        mutableStateOf(true)
    }

    ///
    val textList = remember {
        mutableListOf(
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(0)
                )
            ),
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(0)
                )
            ),
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(0)
                )
            ),
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(0)
                )
            )
        )
    }

    val requesterList = listOf(
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester()
    )

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current


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

//                OutlinedTextField(
//                    value = otpCode.value,
//                    onValueChange = { otp ->
//                        otpCode.value = otp
//                        isOtpValid.value = true
//                    },
//                    placeholder = { Text(text = "1234") },
//                    textStyle = TextStyle(fontFamily = FontFamily(Font(R.font.urbanist_regular))),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 20.dp),
//                    singleLine = true,
//                    maxLines = 1,
//                    isError = !isOtpValid.value,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedBorderColor = Color(0xFF2B5EC0),
//                        cursorColor = Color(0xFF2B5EC0)
//                    ),
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Number,
//                        imeAction = ImeAction.Go
//                    )
//                )

//                if (!isOtpValid.value) {
//                    Text(
//                        modifier = Modifier.padding(start = 22.dp, top = 2.dp),
//                        text = "Kindly enter a valid 4 digit Otp",
//                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
//                        style = MaterialTheme.typography.caption,
//                        color = MaterialTheme.colors.error
//                    )
//                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                        //.align(Alignment.TopCenter)
                ) {
                    for (i in textList.indices) {
                        InputView(
                            value = textList[i].value,
                            onValueChange = { newValue ->
                                // Returning when old value is not empty
                                if (textList[i].value.text != "") {
                                    if(newValue.text == "") {
                                        // before returning, if new value is empty, set text field to empty
                                        textList[i].value = TextFieldValue(
                                            text = "",
                                            selection = TextRange(0)
                                        )
                                    }
                                    return@InputView
                                }
                                // Set new value and move to the end
                                textList[i].value = TextFieldValue(
                                    text = newValue.text,
                                    selection = TextRange(newValue.text.length)
                                )

                                connectInputedCode(textList) {
                                    focusManager.clearFocus()
                                    keyboardController?.hide()

                                    if(it) {
                                        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                                    } else {
                                        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                                        for (text in textList) {
                                            text.value = TextFieldValue(
                                                text = "",
                                                selection = TextRange(0)
                                            )
                                        }
                                    }
                                }

                                nextFocus(textList, requesterList)
                            },
                            focusRequester = requesterList[i])
                    }

                    LaunchedEffect(key1 = null, block = {
                        delay(300)
                        requesterList[0].requestFocus()
                    })
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
//                    isOtpValid.value = validateCode(inputCode = otpCode.value)
//
//                    if (isOtpValid.value) {
//                        // Verify Otp
//                        Log.i("Code Valid", " - ${isOtpValid.value}")
//                        Toast.makeText(
//                            context,
//                            "Valid - ${isOtpValid.value}", Toast.LENGTH_SHORT
//                        ).show()
//                    }
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

private fun connectInputedCode(
    textList: List<MutableState<TextFieldValue>>,
    onVerifyCode : ((success: Boolean) -> Unit)? = null
) {
    var code = ""
    for (text in textList) {
        code += text.value.text
    }
    if (code.length == 4) {
        verifyCode(
            code,
            onSuccess = {
                onVerifyCode?.let {
                    it(true)
                }
            },
            onFail = {
                onVerifyCode?.let {
                    it(false)
                }
            }
        )
    }
}

private fun verifyCode(
    code : String,
    onSuccess : () -> Unit,
    onFail : () -> Unit
) {
    if(code == "1234") {
        onSuccess()
    } else {
        onFail()
    }
}

private fun nextFocus(textList: List<MutableState<TextFieldValue>>, requesterList: List<FocusRequester>) {
    for (index in textList.indices) {
        if (textList[index].value.text == "") {
            if (index < textList.size) {
                requesterList[index].requestFocus()
                break
            }
        }
    }
}

@Composable
private fun InputView(
    value: TextFieldValue,
    onValueChange : (value : TextFieldValue) -> Unit,
    focusRequester: FocusRequester
) {
    BasicTextField(
        readOnly = false,
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .border(BorderStroke(1.dp, Color(0xFF2B5EC0)), shape = RoundedCornerShape(5.dp))
            .background(Color.Transparent)
            .wrapContentSize()
            .focusRequester(focusRequester),
        maxLines = 1,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(70.dp),
                contentAlignment = Alignment.Center
            ) {
                innerTextField()
            }
        },
        cursorBrush = SolidColor(Color.Black),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = null)
    )

}


//fun validateCode(inputCode: String): Boolean {
//    return inputCode.length == 4
//}