package com.appslabke.every_shillings_android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R

@Preview(showBackground= true, showSystemUi = true)
@Composable
fun HomeScreen(){

}

@Preview
@Composable
fun HomeContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Welcome John Doe",
                modifier = Modifier.padding(start = 18.dp),
                style = TextStyle(
                    fontSize = 25.sp
                )
            )
            Image(
                painterResource(R.drawable.account_icon),
                modifier = Modifier.padding(end = 20.dp),
                contentDescription = "person profile")
        }

        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
                .border(1.dp, color = Color(0xFF2B5EC0), RoundedCornerShape(12.dp))

        ) {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Row(modifier = Modifier.padding(top = 15.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "KES Account",
                        style = TextStyle(
                            fontSize = 25.sp
                        )
                    )
                    Image(
                        painterResource(R.drawable.arrow_drop_down),
                        contentDescription = "currency")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(bottom = 12.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(text = "Your Balance",
                            style = TextStyle(
                                fontSize = 22.sp
                            )
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(text = "Ksh 300,400",
                            style = TextStyle(
                                fontSize = 25.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    Column(verticalArrangement = Arrangement.Bottom) {
                        Button(onClick = { /*TODO*/ },
                            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                            colors = ButtonDefaults.buttonColors(Color(0xFF2B5EC0))
                        ) {
                            Text(text = "Deposit",
                                modifier = Modifier.padding(horizontal = 8.dp),
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    color = Color.White
                                )
                            )
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF2B5EC0))) {
                Text(text = "Buy",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF2B5EC0))
            ) {
                Text(text = "Sell",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(120.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF2B5EC0))) {
                Text(text = "Withdraw",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun ExchangeGraph() {

}
