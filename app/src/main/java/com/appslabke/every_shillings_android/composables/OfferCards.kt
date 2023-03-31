package com.appslabke.every_shillings_android.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OfferCards(
    modifier: Modifier = Modifier, hasOffers: Boolean
) {

    Column(modifier = modifier) {
        if (!hasOffers)
            Text("No Offers")
        else
            LazyColumn() {
                items(items = (0..5).toList()) { OfferCard() }
            }
    }

}