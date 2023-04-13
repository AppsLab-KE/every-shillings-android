package com.appslabke.every_shillings_android.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MarketPlaceDetailedScreen() {

    Scaffold (
        modifier = Modifier,
        topBar = {
            TopAppBar(
            title = {Text("MarketPlace Detail", style = androidx.compose.ui.text.TextStyle(fontSize = 15.sp), color = Color.White)},
                navigationIcon =  {
                    IconButton(onClick = { /*TODO*/ }) {
                       Icon(imageVector = Icons.Default.ArrowBack,
                           contentDescription = "ArrowBack",
                           tint = Color.White

                       )
                    }
                },
            backgroundColor = Color(0xFF2B5EC0)
            )
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(all = 20.dp),
                verticalArrangement = Arrangement.SpaceAround

            ){
                Surface(elevation = 10.dp, shape = RoundedCornerShape(16.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()

                            .height(160.dp)

                            .border(
                                border = BorderStroke(1.dp, Color(0xFF2B5EC0)),
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .padding(14.dp)
                                .align(Alignment.TopStart),
                            verticalArrangement = Arrangement.spacedBy(2.dp)

                        ) {
                            Text(
                                modifier = Modifier,
                                fontSize = 20.sp,
                                text = "You pay",
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily(Font(R.font.urbanist_regular))
                            )
                            Text(
                                fontSize = 20.sp,
                                text = "$ 400",
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.urbanist_regular))
                            )
                        }

                        Spacer(modifier = Modifier.height(30.dp))
                        Column(
                            modifier = Modifier
                                .padding(14.dp)
                                .align(Alignment.BottomStart),
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Text(
                                text = "Total balance",
                                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                text = "$ 500",
                                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .padding(horizontal = 11.dp)
                                .align(Alignment.CenterEnd),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFF2B5EC0)
                            ),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 3.dp, vertical = 5.dp),
                                color = Color.White,
                                text = "Currency",
                                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                fontSize = 16.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        modifier = Modifier
                            .width(64.67.dp)
                            .height(41.07.dp),
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "exchange horizontal",
                        alignment = Alignment.Center)
                }
                Spacer(modifier = Modifier.height(10.dp))

                Surface(elevation = 10.dp, shape = RoundedCornerShape(16.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()

                            .height(160.dp)

                            .border(
                                border = BorderStroke(1.dp, Color(0xFF2B5EC0)),
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .padding(14.dp)
                                .align(Alignment.TopStart),
                            verticalArrangement = Arrangement.spacedBy(2.dp)

                        ) {
                            Text(
                                modifier = Modifier,
                                fontSize = 20.sp,
                                text = "You pay",
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily(Font(R.font.urbanist_regular))
                            )
                            Text(
                                fontSize = 20.sp,
                                text = "$ 400",
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.urbanist_regular))
                            )
                        }

                        Spacer(modifier = Modifier.height(30.dp))
                        Column(
                            modifier = Modifier
                                .padding(14.dp)
                                .align(Alignment.BottomStart),
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Text(
                                text = "Total balance",
                                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                text = "$ 500",
                                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .padding(horizontal = 11.dp)
                                .align(Alignment.CenterEnd),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFF2B5EC0)
                            ),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(horizontal = 3.dp, vertical = 5.dp),
                                color = Color.White,
                                text = "Currency",
                                fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                                fontSize = 16.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(0.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(16.dp),

                    ) {
                    Text(
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        text = "Exchange rate"
                    )
                    Text(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        text = "1 USD = KES 128"
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(16.dp),

                    ) {
                    Text(
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        text = "Transfer fee"
                    )
                    Text(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        text = "2%"
                    )
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()

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
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        fontSize = 16.sp
                    )
                }
            }
        }
     )
}