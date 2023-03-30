package com.appslabke.every_shillings_android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R
import com.appslabke.every_shillings_android.composables.OfferCards
import com.appslabke.every_shillings_android.composables.Selection


@Preview(showBackground = true)
@Composable
fun MarketPlace() {


    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(16.dp),
                backgroundColor = Color(0xFF2B5EC0),
                contentColor = Color.White,
                onClick = {}) {
                Icon(Icons.Filled.Add, "FAB")
            }
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(top = 30.dp, start = 20.dp),
                fontWeight = FontWeight.W400,
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                text = stringResource(R.string.market_place)
            )
            Selection()
            OfferCards(hasOffers = true)
        }
    }
}

