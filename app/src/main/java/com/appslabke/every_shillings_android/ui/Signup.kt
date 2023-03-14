package com.appslabke.every_shillings_android.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.ui.theme.EveryshillingsandroidTheme
import com.togitech.ccp.component.TogiCountryCodePicker
import com.togitech.ccp.component.getFullPhoneNumber
import com.togitech.ccp.component.getOnlyPhoneNumber
import com.togitech.ccp.component.isPhoneNumber

@Composable
fun Signup(modifier: Modifier = Modifier) {
    val fullName = rememberSaveable { mutableStateOf("") }
    val email = rememberSaveable { mutableStateOf("") }
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    val fullPhoneNumber = rememberSaveable { mutableStateOf("") }
    val onlyPhoneNumber = rememberSaveable { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val checkState = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()


    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .pointerInput(Unit) {
                    detectTapGestures {
                        focusManager.clearFocus()
                    }
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(56.dp))
            Text(
                text = "Sign up",
                color = Color(0xFF2B5EC0),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(
                text = "Signup with your Email and phone number",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = modifier.height(30.dp))
            TextInputField(
                modifier = modifier,
                focusRequester = focusRequester,
                fieldTextState =  fullName,
                fieldLabel =  "Full Name",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                focusManager = focusManager)
            Spacer(modifier = modifier.height(20.dp))

            TextInputField(
                modifier = modifier,
                focusRequester = focusRequester,
                fieldTextState = email,
                fieldLabel = "Email",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                focusManager = focusManager
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(
                text = "Phone Number",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            TogiCountryCodePicker( modifier = modifier
                .background(Color.Transparent)
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .offset(y = (-16).dp),

                text = phoneNumber.value,
                color = Color.Transparent,
                onValueChange = {phoneNumber.value = it },
                shape = RoundedCornerShape(4.dp),
                bottomStyle = false,
                showCountryFlag = false,
                unfocusedBorderColor = Color.Gray

            )
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = "You will receive an OTP",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            )
            Spacer(modifier = modifier.height(20.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkState.value,
                    onCheckedChange = { isChecked -> checkState.value = isChecked },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF2B5EC0)
                    )
                )
                AnnotatedTermsAndPolicies()
            }
            Spacer(modifier = modifier.height(10.dp))
            Button(
                onClick = {
                    focusManager.clearFocus()
                    if (!isPhoneNumber()) {
                        fullPhoneNumber.value = getFullPhoneNumber()
                        onlyPhoneNumber.value = getOnlyPhoneNumber()
                    } else {
                        fullPhoneNumber.value = "Error"
                        onlyPhoneNumber.value = "Error"
                    }

                    /*TODO()*/
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                contentPadding = PaddingValues(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF2B5EC0),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Signup", fontSize = 18.sp)
            }
            Spacer(modifier = modifier.height(10.dp))
            AnnotatedLoginText()
            Spacer(modifier = modifier.height(50.dp))

        }

    }
}

@Composable
fun TextInputField(
    modifier: Modifier,
    focusRequester: FocusRequester,
    fieldTextState: MutableState<String>,
    fieldLabel: String,
    keyboardOptions: KeyboardOptions,
    focusManager: FocusManager
) {
    Text(
        text = fieldLabel,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    )
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .padding(horizontal = 20.dp),
        value = fieldTextState.value,
        onValueChange = { fieldTextState.value = it },
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        keyboardOptions = keyboardOptions,
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
}

@Composable
fun AnnotatedTermsAndPolicies() {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        append("I agree to ")

        pushStringAnnotation(
            tag = "terms_conditions",
            annotation = "Terms and Conditions page"
        )

        withStyle(
            style = SpanStyle(color = Color(0xFF2B5EC0))
        ) {
            append("Terms and Conditions")
        }
        pop()
        append(" and ")
        pushStringAnnotation(
                tag = "privacy_policies",
                annotation = "Privacy Policies page"
            )
        withStyle(style = SpanStyle(color = Color(0xFF2B5EC0))
        ) {
            append("Privacy Policies")
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        style = TextStyle.Default.copy(fontSize = 16.sp),
        onClick = { offset ->
        annotatedText.getStringAnnotations(
            tag = "terms_conditions",
            start = offset,
            end = offset
        ).firstOrNull()?.let { annotation ->
            Toast.makeText(context, annotation.item, Toast.LENGTH_SHORT).show()
        }

        annotatedText.getStringAnnotations(
            tag = "privacy_policies",
            start = offset,
            end = offset
        ).firstOrNull()?.let { annotation ->
            Toast.makeText(context, annotation.item, Toast.LENGTH_SHORT).show()
        }

    })

}

@Composable
fun AnnotatedLoginText() {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        append("Already have an account? ")
        pushStringAnnotation(
            tag = "navigate_login",
            annotation = "Navigate to Login"
        )
        withStyle(
            style = SpanStyle(
                color = Color(0xFF2B5EC0)
            )
        ){
            append("Login")
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        style = TextStyle.Default.copy(fontSize = 16.sp),
        onClick = {offset->
            annotatedText.getStringAnnotations(
                tag = "navigate_login",
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                Toast.makeText(context, annotation.item, Toast.LENGTH_SHORT).show()
                /*TODO()*/
            }

    })
}

@Preview(showSystemUi = true)
@Composable
fun SignupPreview() {
    EveryshillingsandroidTheme {
        Signup()
    }
}
