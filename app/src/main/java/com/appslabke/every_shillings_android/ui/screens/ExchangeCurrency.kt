package com.appslabke.every_shillings_android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.appslabke.every_shillings_android.destinations.TopupScreenDestination
import com.appslabke.every_shillings_android.navigation.BottomNavigationBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination
@Composable
fun ExchangeCurrency(
    navigator: DestinationsNavigator
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navigator) },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
        ) {

            Text(
                modifier = Modifier
                    .padding(top = 32.dp),
                fontSize = 24.sp,
                text = "Exchange Currency",
                color = Color(0xFF000000),
            )


            Text(
                modifier = Modifier
                    .padding(top = 36.dp),
                fontSize = 16.sp,
                text = "You buy",
                color = Color(0xFF4D4D4D),
            )


            var expandedBuy by remember { mutableStateOf(false) }
            val buySuggestions = listOf("USD", "EUR", "GBP", "CAD", "KES")
            var buySelectedText by remember { mutableStateOf("") }
            var buyTextFieldSize by remember { mutableStateOf(Size.Zero) }

            val buyIcon = if (expandedBuy)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.ArrowDropDown

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .border(1.5.dp, Color(0xFF2B5EC0), RoundedCornerShape(8.dp))
            ) {

                OutlinedTextField(
                    value = buySelectedText,
                    enabled = false,
                    onValueChange = { buySelectedText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            buyTextFieldSize = coordinates.size.toSize()
                        },
                    trailingIcon = {
                        Icon(buyIcon, "contentDescription",
                            Modifier.clickable { expandedBuy = !expandedBuy })
                    },
                )


                DropdownMenu(
                    expanded = expandedBuy,
                    onDismissRequest = { expandedBuy = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { buyTextFieldSize.width.toDp() })
                ) {
                    buySuggestions.forEach { label ->
                        DropdownMenuItem(onClick = {
                            buySelectedText = label
                            expandedBuy = false
                        }) {
                            Text(text = label)
                        }
                    }
                }
            }


            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                fontSize = 16.sp,
                text = "Amount",
                color = Color(0xFF4D4D4D),
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(top = 16.dp)
                    .border(1.5.dp, Color(0xFF2B5EC0), RoundedCornerShape(8.dp))
            ) {

                var amountSelectedText by remember { mutableStateOf("") }
                val focusRequester = remember { FocusRequester() }
                val focusManager = LocalFocusManager.current

                OutlinedTextField(
                    value = amountSelectedText,
                    onValueChange = { amountSelectedText = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    colors = TextFieldDefaults
                        .textFieldColors(
                            unfocusedIndicatorColor = Color(0xFFFFFFFF),
                            focusedIndicatorColor = Color(0xFFFFFFFF),
                            cursorColor = Color(0xFF2B5EC0),
                            backgroundColor = Color(0xFFFFFFFF)
                        )
                )

                Box(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .align(Alignment.CenterEnd)
                        .size(width = 73.8.dp, height = 41.dp)
                        .border(1.5.dp, Color(0xFF2B5EC0), RoundedCornerShape(8.dp)),

                    ) {

                    var rateValue by remember { mutableStateOf("128") }
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center),
                        color = Color(0xFF2B5EC0),
                        text = "Rate: $rateValue",
                        fontSize = 15.sp
                    )
                }

            }


            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                fontSize = 16.sp,
                text = "Pay in",
                color = Color(0xFF4D4D4D),
            )

            var expandedPayIn by remember { mutableStateOf(false) }
            val payInSuggestions = listOf("USD", "EUR", "GBP", "CAD", "KES")
            var payInSelectedText by remember { mutableStateOf("") }
            var payInTextFieldSize by remember { mutableStateOf(Size.Zero) }

            val payInIcon = if (expandedPayIn)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.ArrowDropDown

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .border(1.5.dp, Color(0xFF2B5EC0), RoundedCornerShape(8.dp))
            ) {

                OutlinedTextField(
                    value = payInSelectedText,
                    enabled = false,
                    onValueChange = { payInSelectedText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            payInTextFieldSize = coordinates.size.toSize()
                        },
                    trailingIcon = {
                        Icon(payInIcon, "contentDescription",
                            Modifier.clickable { expandedPayIn = !expandedPayIn })
                    },
                )


                DropdownMenu(
                    expanded = expandedPayIn,
                    onDismissRequest = { expandedPayIn = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { payInTextFieldSize.width.toDp() })
                ) {
                    payInSuggestions.forEach { label ->
                        DropdownMenuItem(onClick = {
                            payInSelectedText = label
                            expandedPayIn = false
                        }) {
                            Text(text = label)
                        }
                    }
                }
            }


            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                fontSize = 16.sp,
                text = "Delivery",
                color = Color(0xFF4D4D4D),
            )

            var expandedDelivery by remember { mutableStateOf(false) }
            val deliverySuggestions = listOf(
                "Runda", "Lavington", "Kileleshwa",
                "Muthaiga", "Nairobi"
            )
            var deliverySelectedText by remember { mutableStateOf("") }
            var deliveryTextFieldSize by remember { mutableStateOf(Size.Zero) }

            val deliveryIcon = if (expandedDelivery)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.ArrowDropDown

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .border(1.5.dp, Color(0xFF2B5EC0), RoundedCornerShape(8.dp))
            ) {

                OutlinedTextField(
                    value = deliverySelectedText,
                    enabled = false,
                    onValueChange = { deliverySelectedText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            deliveryTextFieldSize = coordinates.size.toSize()
                        },
                    trailingIcon = {
                        Icon(deliveryIcon, "contentDescription",
                            Modifier.clickable { expandedDelivery = !expandedDelivery })
                    },


                    )


                DropdownMenu(
                    expanded = expandedDelivery,
                    onDismissRequest = { expandedDelivery = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { deliveryTextFieldSize.width.toDp() })
                ) {
                    deliverySuggestions.forEach { label ->
                        DropdownMenuItem(onClick = {
                            deliverySelectedText = label
                            expandedDelivery = false
                        }) {
                            Text(text = label)
                        }
                    }
                }
            }


            Text(
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 16.dp),
                fontSize = 20.sp,
                text = "Total Amount :   \$ 123,000",
                color = Color(0xFF000000),
            )


            Button(
                onClick = {  navigator.navigate(TopupScreenDestination()) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(top = 8.dp),

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF2B5EC0),
                    contentColor = Color.White
                )
            )
            {
                Text(text = "Book order", modifier = Modifier)
            }

        }

    }
}


