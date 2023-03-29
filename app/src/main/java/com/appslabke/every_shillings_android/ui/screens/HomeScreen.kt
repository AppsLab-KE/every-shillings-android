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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R
import com.github.tehras.charts.line.LineChart
import com.github.tehras.charts.line.LineChartData
import com.github.tehras.charts.line.renderer.line.SolidLineDrawer
import com.github.tehras.charts.line.renderer.point.FilledCircularPointDrawer
import com.github.tehras.charts.line.renderer.xaxis.SimpleXAxisDrawer
import com.github.tehras.charts.line.renderer.yaxis.SimpleYAxisDrawer
import com.github.tehras.charts.piechart.animation.simpleChartAnimation

@Preview(showBackground= true, showSystemUi = true)
@Composable
fun HomeScreen(){
    HomeContent()
}

@Preview
@Composable
fun HomeContent() {

    // Header
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
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = Color.Black
                )
            )
            Image(
                painterResource(R.drawable.account_icon),
                modifier = Modifier.padding(end = 20.dp),
                contentDescription = "person profile")
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Currency & Balance
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
                            fontSize = 25.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = Color.Black
                        ))
                    Image(
                        painterResource(R.drawable.arrow_drop_down),
                        contentDescription = "currency")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(bottom = 15.dp)
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(text = "Your Balance",
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color.Black
                            ))

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(text = "Ksh 300,400",
                            style = TextStyle(
                                fontSize = 25.sp,
                                fontWeight = FontWeight.W900,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = Color.Black
                            ))

                        Spacer(modifier = Modifier.height(12.dp))
                    }
                    Column(verticalArrangement = Arrangement.Bottom) {
                        Button(onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF2B5EC0))
                        ) {
                            Text(text = "Deposit",
                                modifier = Modifier.padding(horizontal = 8.dp),
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    color = Color.White,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                                ))
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(100.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF2B5EC0))) {
                Text(text = "Buy",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    ))
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(100.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF2B5EC0))
            ) {
                Text(text = "Sell",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    ))
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.width(120.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF2B5EC0))) {
                Text(text = "Withdraw",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    ))
            }
        }

        // Currency Graph
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "KES/USD",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    ))

                Text(text = "+34%",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    ))
            }
        }

        LineChart(
            linesChartData = listOf(
                LineChartData(points = listOf(LineChartData.Point(0f,"1"), LineChartData.Point(2f,"2"),
                    LineChartData.Point(2f,"3"), LineChartData.Point(2f,"4"),
                    LineChartData.Point(5f,"5"), LineChartData.Point(0f,"6"),
                    LineChartData.Point(2.5f,"7")),
                    padBy = 1f, startAtZero = true, lineDrawer = SolidLineDrawer(2.dp, Color.Red)
                )
            ),
            // Optional properties.
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(end = 25.dp),
            animation = simpleChartAnimation(),
            pointDrawer = FilledCircularPointDrawer(1.dp),
            xAxisDrawer = SimpleXAxisDrawer(labelTextSize = 15.sp, labelTextColor = Color.Black,
                labelRatio = 1, axisLineColor = Color.Transparent),
            yAxisDrawer = SimpleYAxisDrawer(labelTextSize = 2.sp, labelTextColor = Color.Transparent,
                labelRatio = 1, axisLineThickness = 0.dp, axisLineColor = Color.Transparent),
            horizontalOffset = 6f,
            labels = listOf("21:00", "Today", "6:00", "9:00", "11:00", "14:00")
        )

        Row(modifier = Modifier.width(250.dp)
            .padding(vertical = 20.dp, horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "1d",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                ))
            Text(text = "5d",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                ))
            Text(text = "1m",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                ))
            Text(text = "1y",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                ))
        }
    }
}
