package com.appslabke.every_shillings_android.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.appslabke.every_shillings_android.R

@Composable
fun Selection() {
    val currency = listOf("USD", "EUR", "CAD", "AUD")
    var selectedLeft by remember {
        mutableStateOf(currency.first())
    }
    var selectedRight by remember {
        mutableStateOf(currency.last())
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        DropDownMenu(
            modifier = Modifier.weight(1f), list = currency, selected = selectedLeft
        ) {
            selectedLeft = it
        }
        Image(
            modifier = Modifier
                .width(32.dp)
                .height(21.25.dp),
            painter = painterResource(id = R.drawable.exchange_arrows),
            contentDescription = "Exchange Arrow",
            alignment = Alignment.Center
        )
        DropDownMenu(
            modifier = Modifier.weight(1f), list = currency, selected = selectedRight
        ) {
            selectedRight = it
        }

    }
}