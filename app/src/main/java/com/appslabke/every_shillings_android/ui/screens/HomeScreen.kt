package com.appslabke.every_shillings_android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.appslabke.every_shillings_android.R

@Preview(showBackground= true, showSystemUi = true)
@Composable
fun HomeScreen(){

}

//@Preview
@Composable
fun HomeContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Welcome John Doe")
            Image(
                painterResource(R.drawable.account_icon),
                contentDescription = "person profile")
        }

        Box {

            Text(text = "KES Account")
            Row() {
                Column() {
                    Text(text = "Your Balance")
                    Text(text = "Ksh 300,400")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Deposit")
                }
            }
        }

        Row() {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Buy")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Sell")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Withdraw")
            }
        }
    }
}
