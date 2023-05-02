package com.appslabke.every_shillings_android.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
                .padding(top = 48.dp, start = 0.dp, end = 0.dp)
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
                border = BorderStroke(1.dp, color = MaterialTheme.colors.primary)
            ) {
                Text(text = "Amount: $topUpAmount",
                    modifier = Modifier
                    .padding(17.dp),
                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    color = Color.Gray,
                    fontSize = 16.sp,
                )

            }
            //top account button



        }

    }

}