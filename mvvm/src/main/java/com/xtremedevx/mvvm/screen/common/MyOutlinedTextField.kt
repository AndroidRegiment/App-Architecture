package com.xtremedevx.mvvm.screen.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.StateFlow


@Composable
fun MyOutlinedTextField(
    provideValue: () -> StateFlow<String>,
    onValueChange: (String) -> Unit,
    label : String,
    keyboardOption : KeyboardOptions = KeyboardOptions.Default
) {
    val value by provideValue().collectAsState()
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(label) },
        keyboardOptions = keyboardOption,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onPrimary,
            backgroundColor = MaterialTheme.colors.primary,
            focusedBorderColor = MaterialTheme.colors.primaryVariant,
            focusedLabelColor =  MaterialTheme.colors.primaryVariant,
        )
    )
}