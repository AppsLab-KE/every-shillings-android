package com.appslabke.every_shillings_android.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appslabke.every_shillings_android.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownMenu(
    modifier: Modifier = Modifier.fillMaxWidth(1f),
    list: List<String>,
    selected: String = list.first(),
    onItemSelected: (String) -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }
    ExposedDropdownMenuBox(modifier = modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(horizontal = 16.dp),
        expanded = expanded,
        onExpandedChange = {
            expanded = expanded.not()
        }) {
        // text field
        TextField(
            value = selected,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .border(
                    width = 1.dp, Color(0xFF2B5EC0), shape = RoundedCornerShape(10.dp)
                ),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(backgroundColor = Color.Transparent)
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = expanded.not() }) {
            list.forEach { selectedOption ->
                DropdownMenuItem(onClick = {
                    onItemSelected.invoke(selectedOption)
                    expanded = expanded.not()
                }) {
                    Text(
                        text = selectedOption,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.urbanist_regular)),
                        fontWeight = FontWeight.W400,
                        fontSize = 20.sp

                    )
                }
            }
        }
    }

}