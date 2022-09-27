package com.xtremedevx.app_architecture.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormViewModel : ViewModel(){
    private val _formState = MutableStateFlow(FormState())
    val formState = _formState.asStateFlow()



    fun onEvent(event: FormEvent) {
        when (event) {
            is FormEvent.NameChange -> {
                _formState.value = _formState.value.copy(
                    name = event.name
                )
            }
            is FormEvent.CountryNameChange -> {
                _formState.value = _formState.value.copy(
                    countryName = event.name
                )
            }
            is FormEvent.MobileNumberChange -> {
                _formState.value = _formState.value.copy(
                    mobileNumber = event.number
                )
            }
        }
    }
}