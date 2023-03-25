package com.appslabke.every_shillings_android.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R

@Preview
@Composable
fun MarketPlaceDetailedScreen() {
  Box(
      modifier = Modifier
          .fillMaxWidth()
          .background(color = Color.White)
          .padding(top = 16.dp, start = 16.dp, end = 16.dp)
          .border(border = BorderStroke(1.dp, Color.White))
          .clip(shape = RoundedCornerShape(5.dp))
  ) {
      Column(
          modifier = Modifier
              .fillMaxWidth(1f)
              .align(Alignment.TopStart),
          verticalArrangement = Arrangement.spacedBy(2.dp)

      ) {
          Text(
              modifier = Modifier
                  .padding(10.dp),
              fontSize = 20.sp,
              text = "You pay",
              fontWeight = FontWeight.Normal,
              fontFamily = FontFamily(Font(R.font.poppins_regular))
          )
          Text(
              fontSize = 20.sp,
              text = "$ 400",
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily(Font(R.font.poppins_regular))
          )
      }
      Column(
          modifier = Modifier
              .padding(top = 8.dp)
              .align(Alignment.BottomStart),
          verticalArrangement = Arrangement.spacedBy(2.dp)
      ) {
          Text(
              text = "Total balance",
              fontFamily = FontFamily(Font(R.font.poppins_regular)),
              fontSize = 20.sp,
              fontWeight = FontWeight.Normal
          )
          Text(
              text = "$ 500",
              fontFamily = FontFamily(Font(R.font.poppins_regular)),
              fontWeight = FontWeight.Bold,
              fontSize = 20.sp
          )
      }
      
      Text(
          modifier = Modifier
              .background(Color(0xFF2B5EC0))
              .align(Alignment.CenterEnd)
              .padding(10.dp),
          color = Color.White,
          text = "Currency",
          fontFamily = FontFamily(Font(R.font.poppins_regular)),
          fontSize = 20.sp
      )
  }
    Spacer(modifier = Modifier.height(40.dp))
    
    Image(
        modifier = Modifier
            .width(64.67.dp)
            .height(41.07.dp),
        painter = painterResource(id = R.drawable.img),
        contentDescription = "exchange horizontal",
        alignment = Alignment.Center)
    Spacer(modifier = Modifier.height(40.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .border(border = BorderStroke(1.dp, Color.White))
            .clip(shape = RoundedCornerShape(5.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .align(Alignment.TopStart),
            verticalArrangement = Arrangement.spacedBy(2.dp)

        ) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                fontSize = 20.sp,
                text = "You pay",
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.poppins_regular))
            )
            Text(
                fontSize = 20.sp,
                text = "$ 400",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.poppins_regular))
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.BottomStart),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "Total balance",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "$ 500",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Text(
            modifier = Modifier
                .background(Color(0xFF2B5EC0))
                .align(Alignment.CenterEnd)
                .padding(10.dp),
            color = Color.White,
            text = "Currency",
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontSize = 20.sp
        )
    }
    Spacer(modifier = Modifier.height(40.dp))

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(16.dp),

    ) {
       Text(
           fontSize = 20.sp,
           fontWeight = FontWeight.Bold,
           fontFamily = FontFamily(Font(R.font.poppins_regular)),
           text = "Exchange rate"
       )
        Text(
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            text = "1 USD = KES 128"
        )
    }
    Spacer(modifier = Modifier.height(3.dp))

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(16.dp),

        ) {
        Text(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            text = "Transfer fee"
        )
        Text(
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            text = "2%"
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth()
            .padding(20.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF2B5EC0),
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Order Detail",
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontSize = 16.sp
        )
    }

}