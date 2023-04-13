package com.appslabke.every_shillings_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ForgetPassword : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           ForgetPasswordScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ForgetPasswordScreen(){
    var emailAddress by remember { mutableStateOf("") }

   Column(modifier = Modifier.fillMaxSize(),
   horizontalAlignment = Alignment.CenterHorizontally)
   {
       Text(
           modifier = Modifier.padding(top = 76.dp),
           fontWeight = FontWeight.Bold,
           color = Color.Black,
           fontSize = 20.sp,

           fontFamily = FontFamily(Font(R.font.urbanist_regular)),
           text = stringResource(R.string.title_activity_forget_password)
       )
       Spacer(modifier = Modifier.height(20.dp))
       Text(
           fontWeight = FontWeight.Normal,
           fontSize = 14.sp,

           fontFamily = FontFamily(Font(R.font.urbanist_regular)),
           text = stringResource(R.string.enter_your_email)
       )
       Spacer(modifier = Modifier.height(90.dp))
       Text(
           modifier = Modifier
               .align(Alignment.Start)
               .padding(start = 32.dp),

           fontFamily = FontFamily(Font(R.font.urbanist_regular)),
           fontWeight = FontWeight.Normal,
           text = stringResource(R.string.email)
       )
       Spacer(Modifier.height(4.dp))
       OutlinedTextField(
           modifier = Modifier
               .fillMaxWidth()
               .padding(start = 32.dp, end = 32.dp)
               .height(56.dp),
           value = emailAddress,
           onValueChange = { emailAddress = it }
       )
       Spacer(modifier = Modifier.height(50.dp))
       Text(
           fontWeight = FontWeight.Normal,
           fontSize = 12.sp,

           fontFamily = FontFamily(Font(R.font.urbanist_regular)),
           text = stringResource(R.string.check_email_link)
       )
       Spacer(modifier = Modifier.height(32.dp))
       Button(
           onClick = {  },
           modifier = Modifier
               .fillMaxWidth()
               .padding(start = 32.dp, end = 32.dp)
               .height(56.dp),
           colors = ButtonDefaults.buttonColors(
               backgroundColor = colorResource(R.color.btn_background_color),
               contentColor = colorResource(R.color.btn_text_color)
           )
       ) {
           Text(
               text = stringResource(R.string.reset_btn_text),
               fontWeight = FontWeight.SemiBold,
               textAlign = TextAlign.Center,

               fontFamily = FontFamily(Font(R.font.urbanist_regular)),
               fontSize = 16.sp
           )
       }

   }
}

