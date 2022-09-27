package com.xtremedevx.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormViewModel() : ViewModel() {
    private val _nameFlow = MutableStateFlow("")
    val nameFlow = _nameFlow.asStateFlow()

    private val _countryName = MutableStateFlow("")
    val countryName = _countryName.asStateFlow()

    private val _mobileNumber = MutableStateFlow("")
    val mobileNumber = _mobileNumber.asStateFlow()

    fun updateName(name: String) {
        _nameFlow.value = name
    }
    fun updateCountryName(name: String) {
        _countryName.value = name
    }
    fun updateMobileNumber(number : String) {
        _mobileNumber.value = number
    }

    fun submitTheForm(){
            //TODO : validate the input and show toast
    }

}
