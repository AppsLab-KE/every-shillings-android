package com.appslabke.every_shillings_android.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R

@Composable
fun PaymentMethodDropDown() {
    val paymentMethod = listOf( "Currency note", "Forex card", "Regular card" )
    var selectedLeft by remember {
        mutableStateOf(paymentMethod.first())
    }
    var selectedRight by remember {
        mutableStateOf(paymentMethod.last())
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Payment method",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_regular)),
            modifier = Modifier.padding(start = 20.dp))
        Spacer(modifier = Modifier.height(15.dp))
        DropDownMenu(
            modifier = Modifier.wrapContentSize(),
            list = paymentMethod,
            selected = selectedLeft
        ) {
            selectedLeft = it
        }
        Spacer(modifier = Modifier.height(86.dp))
    }
}