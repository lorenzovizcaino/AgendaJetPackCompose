package com.antonio.agendajetpackcompose.ui.miscompoose

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTextField(number: String, function: (String) -> Unit, texto: String) {
    TextField(
        value = number,
        onValueChange = function,
        label = { Text(texto) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}