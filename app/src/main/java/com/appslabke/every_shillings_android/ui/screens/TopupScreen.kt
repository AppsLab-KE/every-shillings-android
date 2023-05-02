package com.appslabke.every_shillings_android.ui.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R
import com.appslabke.every_shillings_android.composables.PaymentMethodDropDown
import com.appslabke.every_shillings_android.ui.validatePhoneNumber
import com.togitech.ccp.component.getFullPhoneNumber
import com.togitech.ccp.component.getOnlyPhoneNumber

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TopupScreen() {
    val topUpAmount = "$123,000"

    Surface(modifier = Modifier
        .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 48.dp)
        ){
            Text(text = "Top up Account",
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, bottom = 60.dp),
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                fontSize = 24.sp
            )
            // payment method
            PaymentMethodDropDown()
            // detail
            Text(text = "Detail",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                modifier = Modifier.padding(start = 20.dp))

            Spacer(modifier = Modifier.height(15.dp))

            Surface(modifier = Modifier
                .height(160.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, color = Color(0xFF2B5EC0))
            ) {
                Text(text = "Amount: $topUpAmount",
                    modifier = Modifier
                    .padding(17.dp),
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    color = Color.Gray,
                    fontSize = 16.sp,
                )

            }
            Spacer(modifier = Modifier.height(50.dp))
            //top account button
            Button(
                onClick = { /*Top up user transaction*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 50.dp)
                    .padding(horizontal = 20.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF2B5EC0),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Top Account",
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontSize = 16.sp
                )
            }



        }

    }

}