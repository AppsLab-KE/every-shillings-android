package com.appslabke.every_shillings_android.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R

@Composable
fun PaymentMethodDropDown() {
    val paymentMethod = listOf("Currency note", "Forex card", "Regular card")
    val topUpAmount = "$123,000"
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
        Text(text = "Payment method", fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
        Spacer(modifier = Modifier.height(15.dp))
        DropDownMenu(
            modifier = Modifier.wrapContentSize(),
            list = paymentMethod, selected = selectedLeft
        ) {
            selectedLeft = it
        }
        Spacer(modifier = Modifier.height(86.dp))
        
        Surface(modifier = Modifier
            .height(160.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            border = BorderStroke(1.dp, color = MaterialTheme.colors.primaryVariant)
        ) {
            Text(text = "Amount: $topUpAmount", modifier = Modifier
                .padding(20.dp))

        }

    }
}