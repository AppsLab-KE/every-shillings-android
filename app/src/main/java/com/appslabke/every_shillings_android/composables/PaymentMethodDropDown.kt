package com.appslabke.every_shillings_android.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.appslabke.every_shillings_android.R

@Composable
fun PaymentMethodDropDown() {
    val paymentMethod = listOf("Currency note", "Forex card", "Regular card")
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
        Text(text = "Payment")
        Spacer(modifier = Modifier.height(20.dp))
        DropDownMenu(
            modifier = Modifier.wrapContentSize(), list = paymentMethod, selected = selectedLeft
        ) {
            selectedLeft = it
        }
    }
}