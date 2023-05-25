package com.appslabke.every_shillings_android.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R

@Composable
fun OfferCards(
    modifier: Modifier = Modifier,
    hasOffers: Boolean,
    onclick:() -> Unit

) {

    Column(modifier = modifier) {
        if (!hasOffers)
            Text(
                "No Offers",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .wrapContentHeight(),
                fontWeight = FontWeight.W300,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.urbanist_regular))
            )
        else
            LazyColumn(

            ) {
                items(items = (0..5).toList()) { OfferCard(
                    onclick = {
                        onclick()
                    }
                ) }
            }
    }

}