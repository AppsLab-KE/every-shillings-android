package com.appslabke.every_shillings_android.ui

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.appslabke.every_shillings_android.R
import com.appslabke.every_shillings_android.ui.theme.EveryshillingsandroidTheme
import com.appslabke.every_shillings_android.viewmodel.MainViewModel
import com.togitech.ccp.component.TogiCodeDialog
import com.togitech.ccp.data.utils.getLibCountries

@Composable
fun Signup(
    modifier: Modifier = Modifier,
    navigateToVerifySignUpOtpScreen: () -> Unit,
    navigateToLoginScreen: () -> Unit
) {
    val fullName = rememberSaveable { mutableStateOf("") }
    val email = rememberSaveable { mutableStateOf("") }
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    val phoneCode = rememberSaveable { mutableStateOf("+254") }
    val fullPhoneNumber = rememberSaveable { mutableStateOf("") }
    val phoneNumberInvalid = rememberSaveable { mutableStateOf(false) }
    val emailInvalid = rememberSaveable { mutableStateOf(false) }
    val fullNameInvalid = rememberSaveable { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val checkState = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val viewModel: MainViewModel = hiltViewModel()

    // start auto-read otp from the message
    /*LaunchedEffect(key1 = viewModel.shouldRetrieveSms.value ){
        launch {
            if (viewModel.shouldRetrieveSms.value){
                startSmsRetrieverClient(context)
            }
        }
    }*/

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
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
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 25.sp,
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(
                text = "Signup with your Email and Phone number",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 18.sp,
                modifier = modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = modifier.height(30.dp))
            TextInputField(
                modifier = modifier,
                focusRequester = focusRequester,
                fieldTextState = fullName,
                fieldLabel = "Full Name",
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                focusManager = focusManager,
                isError = fullNameInvalid,
                onValueChange = {
                    fullName.value = it
                    if (fullName.value.length > 7) fullNameInvalid.value = false
                }
            )
            if (fullNameInvalid.value) {
                Text(
                    text = "Enter valid name",
                    color = MaterialTheme.colors.error,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                )
            }
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
                focusManager = focusManager,
                isError = emailInvalid,
                onValueChange = {
                    email.value = it
                    if (email.value.trim().isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
                        emailInvalid.value = false
                    }
                }
            )
            if (emailInvalid.value) {
                Text(
                    text = "Enter a valid email address",
                    color = MaterialTheme.colors.error,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                )
            }
            Spacer(modifier = modifier.height(20.dp))
            Text(
                text = "Phone Number",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 10.dp
                    )
            )

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth(),
                value = phoneNumber.value,
                onValueChange = {
                    phoneNumber.value = it
                    fullPhoneNumber.value = phoneCode.value + phoneNumber.value
                    if (phoneNumber.value.length == 9



                    ) phoneNumberInvalid.value = false
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
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                )
            }

            /* TogiCountryCodePicker( modifier = modifier
                 .background(Color.Transparent)
                 .fillMaxWidth()
                 .padding(horizontal = 4.dp)
                 .offset(y = (-16).dp),

                 text = phoneNumber.value,
                 color = Color.Transparent,
                 onValueChange = {phoneNumber.value = it },
                 shape = RoundedCornerShape(4.dp),
                 bottomStyle = false,
                 showCountryFlag = true,
                 unfocusedBorderColor = MaterialTheme.colors.onSurface.copy(alpha = 0.42f),
             )*/

            Spacer(modifier = modifier.height(30.dp))
            Text(
                text = "You will receive an OTP",
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 20.sp,
            )
            Spacer(modifier = modifier.height(30.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkState.value,
                    onCheckedChange = { isChecked -> checkState.value = isChecked },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary
                    )
                )
                AnnotatedTermsAndPolicies()
            }
            Spacer(modifier = modifier.height(10.dp))
            Button(
                onClick = {
                    focusManager.clearFocus()
                    when {
                        fullName.value.trim().isEmpty() || fullName.value.length < 7 -> {
                            fullNameInvalid.value = true
                        }
                        email.value.trim().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email.value).matches()-> {
                            emailInvalid.value = true
                        }
                        phoneNumber.value.length != 9 ||
                        !phoneNumber.value.contains("^7".toRegex()) &&
                        !phoneNumber.value.contains("^1".toRegex())
                        -> {
                            phoneNumberInvalid.value = true
                        }
                        !checkState.value -> {
                            Toast.makeText(
                                context,
                                "Agree to Terms and Conditions to continue",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else -> {
                            fullNameInvalid.value = false
                            emailInvalid.value = false
                            phoneNumberInvalid.value = false
                            // will take user to VerifySignUp screen
                            /*TODO()*/
                            viewModel.shouldRetrieveSms.value = true
                            navigateToVerifySignUpOtpScreen()
                        }
                    }

                },
                modifier = modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text(text = "Sign up", fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)))
            }
            Spacer(modifier = modifier.height(10.dp))
            AnnotatedLoginText(navigateToLoginScreen)
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
    focusManager: FocusManager,
    isError: MutableState<Boolean>,
    onValueChange: (String) -> Unit
) {
    Text(
        text = fieldLabel,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    )
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        value = fieldTextState.value,
        onValueChange = onValueChange,
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
        ),
        isError = isError.value,
        singleLine = true
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
            style = SpanStyle(color = MaterialTheme.colors.primary)
        ) {
            append("Terms and Conditions")
        }
        pop()
        append(" and ")
        pushStringAnnotation(
            tag = "privacy_policies",
            annotation = "Privacy Policies page"
        )
        withStyle(
            style = SpanStyle(color = MaterialTheme.colors.primary)
        ) {
            append("Privacy Policies")
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        style = TextStyle.Default.copy(fontSize = 18.sp),
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
fun AnnotatedLoginText(navigateToLoginScreen: () -> Unit) {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        append("Already have an account? ")
        pushStringAnnotation(
            tag = "navigate_login",
            annotation = "Navigate to Login"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary
            )
        ) {
            append("Login")
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        style = TextStyle.Default.copy(fontSize = 18.sp),
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "navigate_login",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                navigateToLoginScreen()
                /*TODO()*/
            }
        })
}

@Preview(showSystemUi = true)
@Composable
fun SignupPreview() {
    EveryshillingsandroidTheme {
        //Signup()
    }
}
