package com.appslabke.every_shillings_android.ui.screens

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R

class MarketPlaceScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun MarketPlace(){

    val currency = arrayOf("USD", "EUR", "AUD", "CAD")

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedItem by remember {
        mutableStateOf(currency[0])
    }


    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.padding(top = 30.dp, start = 20.dp),
            fontWeight = FontWeight.W400,
            color = Color.Black,
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            text = stringResource(R.string.market_place)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Box(modifier = Modifier)
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ExposedDropdownMenuBox(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(start = 22.dp),
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
                    // text field
                    TextField(
                        value = selectedItem,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .width(149.dp)
                            .height(48.dp)
                            .background(Color.White)
                            .border(
                                width = 1.dp,
                                Color(0xFF2B5EC0),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expanded
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(backgroundColor = Color.White)
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        currency.forEach { selectedOption ->
                            DropdownMenuItem(onClick = {
                                selectedItem = selectedOption
                                expanded = false
                            }) {
                                Text(
                                    text = selectedOption,
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight.W400,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }

                Image(
                    modifier = Modifier
                        .width(32.dp)
                        .height(21.25.dp),
                    painter = painterResource(id = R.drawable.exchange_arrows),
                    contentDescription = "Exchange Arrow",
                    alignment = Alignment.Center
                )

                ExposedDropdownMenuBox(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(end = 19.dp),
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
                    // text field
                    TextField(
                        value = selectedItem,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .width(149.dp)
                            .height(48.dp)
                            .background(Color.White)
                            .border(
                                width = 1.dp,
                                Color(0xFF2B5EC0),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expanded
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(backgroundColor = Color.White)
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        currency.forEach { selectedOption ->
                            DropdownMenuItem(onClick = {
                                selectedItem = selectedOption
                                expanded = false
                            }) {
                                Text(
                                    text = selectedOption,
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight.W400,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }

            }

        }

        Spacer(modifier = Modifier.height(42.dp))

        Card(
            modifier = Modifier
                .background(Color.White)
                .width(375.dp)
                .height(111.dp)
                .padding(start = 20.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 4.dp
        )
        {
            Column(modifier = Modifier)
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 24.sp,
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 24.sp,
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                    Text(
                        "Today",
                        modifier = Modifier,
                        fontWeight = FontWeight.W300,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                    Text(
                        "€1.00 = $1.31",
                        modifier = Modifier
                            .padding(end = 11.dp, top = 7.dp),
                        fontWeight = FontWeight.W300,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                }
            }
        }

        Spacer(modifier = Modifier.height(23.dp))

        Card(
            modifier = Modifier
                .background(Color.White)
                .width(375.dp)
                .height(111.dp)
                .padding(start = 20.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 4.dp
        )
        {
            Column(modifier = Modifier)
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 24.sp,
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 24.sp,
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                    Text(
                        "Today",
                        modifier = Modifier,
                        fontWeight = FontWeight.W300,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                    Text(
                        "€1.00 = $1.31",
                        modifier = Modifier
                            .padding(end = 11.dp, top = 7.dp),
                        fontWeight = FontWeight.W300,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                }
            }
        }

        Spacer(modifier = Modifier.height(23.dp))

        Card(
            modifier = Modifier
                .background(Color.White)
                .width(375.dp)
                .height(111.dp)
                .padding(start = 20.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 4.dp
        )
        {
            Column(modifier = Modifier)
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 24.sp,
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 24.sp,
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                    Text(
                        "Today",
                        modifier = Modifier,
                        fontWeight = FontWeight.W300,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                    Text(
                        "€1.00 = $1.31",
                        modifier = Modifier
                            .padding(end = 11.dp, top = 7.dp),
                        fontWeight = FontWeight.W300,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                }
            }
        }

        Spacer(modifier = Modifier.height(23.dp))

        Card(
            modifier = Modifier
                .background(Color.White)
                .width(375.dp)
                .height(111.dp)
                .padding(start = 20.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 4.dp
        )
        {
            Column(modifier = Modifier)
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 24.sp,
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 24.sp,
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
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                    Text(
                        "Today",
                        modifier = Modifier,
                        fontWeight = FontWeight.W300,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                    Text(
                        "€1.00 = $1.31",
                        modifier = Modifier
                            .padding(end = 11.dp, top = 7.dp),
                        fontWeight = FontWeight.W300,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 18.sp,
                        color = Color(0xFF000000)
                    )

                }
            }
        }

        Spacer(modifier = Modifier.height(53.dp))

        FloatingActionButton(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            backgroundColor = Color(0xFF2B5EC0),
            contentColor = Color.White,
            onClick = {}
        ) {
            Icon(Icons.Filled.Add,"FAB")
        }

    }

}


