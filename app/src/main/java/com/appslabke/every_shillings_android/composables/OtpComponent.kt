package com.example.otp_screenvalidation_jetpackcompose

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

//@Composable
//fun OTPTextFields(
//    modifier: Modifier = Modifier,
//    length: Int,
//    onFilled: (code: String) -> Unit
//) {
//    var code: List<Char> by remember { mutableStateOf(listOf()) }
//
//    val focusRequesters: List<FocusRequester> = remember {
//        val temp = mutableListOf<FocusRequester>()
//        repeat(length) {
//            temp.add(FocusRequester())
//        }
//        temp
//    }
//
//    Row(
//        modifier = Modifier.fillMaxWidth().height(50.dp)
//    ) {
//        (0 until length).forEach { index ->
//            OutlinedTextField(
//                modifier = Modifier
//                    .width(50.dp)
//                    .height(50.dp),
//                textStyle = MaterialTheme.typography.body2.copy(
//                    textAlign = TextAlign.Center, color = Color.White
//                ),
//                singleLine = true,
//                value = code.getOrNull(index = index)?.takeIf {
//                    it.isDigit()
//                }?.toString() ?: "",
//                onValueChange = { value: String ->
//                    if (focusRequesters[index].freeFocus()) {
//                        val temp = code.toMutableList()
//                        if (value == "") {
//                            if (temp.size > index) {
//                                temp.removeAt(index = index)
//                                code = temp
//                                focusRequesters.getOrNull(index - 1)?.requestFocus()
//                            }
//                        } else {
//                            if (code.size > index) {
//                                temp[index] = value.getOrNull(0)?: ' '
//                            } else {
//                                temp.add(value.getOrNull(0) ?: ' ')
//                                code = temp
//                                focusRequesters.getOrNull(index + 1)?.requestFocus() ?: onFilled(
//                                    code.joinToString(separator = "")
//                                )
//                            }
//                        }
//                    }
//                },
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    keyboardType = KeyboardType.Number,
//                    imeAction = ImeAction.Next
//                ),
//                visualTransformation = PasswordVisualTransformation()
//            )
//
//            Spacer(modifier = Modifier.width(15.dp))
//        }
//    }
//}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun Otp_preview() {
//    val otpVal: String? = null
//    OTPTextFields(
//        length = 4,
//        onFilled = { getotp ->
//            otpVal
//        }
//    )
//}

@Composable
fun CommonOtpTextField(otp: MutableState<String>) {
    val max = 1
    OutlinedTextField(
        value = otp.value,
        singleLine = true,
        onValueChange = { if (it.length <= max) otp.value = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        shape = RoundedCornerShape(17.dp),
        modifier = Modifier
            .width(50.dp)
            .height(50.dp),
        maxLines = 1,
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Center
        )
    )
}