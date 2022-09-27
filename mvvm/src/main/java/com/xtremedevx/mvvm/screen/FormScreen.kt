package com.xtremedevx.mvvm.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.xtremedevx.mvvm.screen.common.MyOutlinedTextField
import com.xtremedevx.mvvm.viewmodel.FormViewModel
import kotlinx.coroutines.flow.StateFlow

@Composable
fun FormScreen(
    viewModel: FormViewModel,) {
    FormScreenContent(
        onNameValueChange = { viewModel.updateName(it) },
        nameProvider = { viewModel.nameFlow },
        onCountryNameChange = { viewModel.updateCountryName(it) },
        countryNameProvider = { viewModel.countryName },
        onMobileNumberChange = { viewModel.updateMobileNumber(it) },
        mobileNumberProvider = { viewModel.mobileNumber },
        onSubmitButtonClick = { viewModel.submitTheForm() },
    )
}


@Composable
fun FormScreenContent(
    onNameValueChange: (String) -> Unit,
    nameProvider: () -> StateFlow<String>,
    onCountryNameChange: (String) -> Unit,
    countryNameProvider: () -> StateFlow<String>,
    onMobileNumberChange: (String) -> Unit,
    mobileNumberProvider: () -> StateFlow<String>,
    onSubmitButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        MyOutlinedTextField(
            onValueChange = onNameValueChange,
            provideValue = { nameProvider() },
            label = "Enter your name"
        )
        MyOutlinedTextField(
            onValueChange = onCountryNameChange,
            provideValue = { countryNameProvider() },
            label = "Enter your country"
        )
        MyOutlinedTextField(
            onValueChange = onMobileNumberChange,
            provideValue = { mobileNumberProvider() },
            label = "Enter your phone number",
            keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = { onSubmitButtonClick() }) {
            Text(text = "Submit")
        }

    }
}