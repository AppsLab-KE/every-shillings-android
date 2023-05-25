package com.appslabke.every_shillings_android.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R


@Preview(showBackground = true)
@Composable
fun OfferCard(
    onclick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
            .fillMaxWidth().clickable {
                onclick()
            },
        shape = RoundedCornerShape(6.dp),
        elevation = 3.dp
    )
    {
        Column(modifier = Modifier.padding(16.dp))
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    "$1000.00",
                    modifier = Modifier
                        .padding(start = 11.dp, top = 7.dp),
                    fontWeight = FontWeight.W400,

                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontSize = 20.sp,
                    color = Color(0xFF2B5EC0)
                )

                Image(
                    modifier = Modifier
                        .width(29.2.dp)
                        .height(13.94.dp),
                    painter = painterResource(id = R.drawable.exchange_green_arrow),
                    contentDescription = "Exchange Green Arrow"
                )

                Text(
                    "$76.85",
                    modifier = Modifier
                        .padding(end = 11.dp, top = 7.dp),
                    fontWeight = FontWeight.W400,

                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontSize = 20.sp,
                    color = Color(0xFF2B5EC0)
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    "$1.00 = €0.77",
                    modifier = Modifier
                        .padding(start = 11.dp, top = 7.dp),
                    fontWeight = FontWeight.W300,

                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontSize = 15.sp,
                    color = Color(0xFF000000)
                )

                Text(
                    "Today",
                    modifier = Modifier,
                    fontWeight = FontWeight.W300,

                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontSize = 15.sp,
                    color = Color(0xFF000000)
                )

                Text(
                    "€1.00 = $1.31",
                    modifier = Modifier
                        .padding(end = 11.dp, top = 7.dp),
                    fontWeight = FontWeight.W300,

                    fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                    fontSize = 15.sp,
                    color = Color(0xFF000000)
                )

            }
        }
    }
}

