package com.xtremedevx.app_architecture.screen.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun MyOutlinedTextField(
    provideValue: () -> String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOption: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = provideValue(),
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