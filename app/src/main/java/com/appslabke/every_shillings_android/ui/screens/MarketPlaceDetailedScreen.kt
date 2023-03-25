package com.appslabke.every_shillings_android.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
}