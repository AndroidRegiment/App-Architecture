package com.xtremedevx.app_architecture

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.xtremedevx.app_architecture.model.FormEvent
import com.xtremedevx.app_architecture.model.FormState
import com.xtremedevx.app_architecture.model.FormViewModel
import com.xtremedevx.app_architecture.screen.common.MyOutlinedTextField
import kotlinx.coroutines.flow.StateFlow

@Composable
fun FormScreen(
    viewModel: FormViewModel,
) {
    FormScreenContent(
        provideState = { viewModel.formState },
        onNameValueChange = { viewModel.onEvent(FormEvent.NameChange(it)) },
        onCountryNameChange = { viewModel.onEvent(FormEvent.CountryNameChange(it)) },
        onMobileNumberChange = { viewModel.onEvent(FormEvent.MobileNumberChange(it)) },
        onSubmitButtonClick = { viewModel.onEvent(FormEvent.NameChange("")) },
    )
}


@Composable
fun FormScreenContent(
    provideState: () -> StateFlow<FormState>,

    onNameValueChange: (String) -> Unit,
    onCountryNameChange: (String) -> Unit,
    onMobileNumberChange: (String) -> Unit,
    onSubmitButtonClick: () -> Unit
) {
    val formState by provideState().collectAsState()
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        MyOutlinedTextField(
            onValueChange = { onNameValueChange(it) },
            provideValue = { formState.name },
            label = "Enter your name"
        )
        MyOutlinedTextField(
            onValueChange = { onCountryNameChange(it) },
            provideValue = { formState.countryName },
            label = "Enter your country"
        )
        MyOutlinedTextField(
            onValueChange = { onMobileNumberChange(it) },
            provideValue = { formState.mobileNumber },
            label = "Enter your phone number",
            keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = { onSubmitButtonClick() }) {
            Text(text = "Submit")
        }

    }
}
