package com.xtremedevx.app_architecture.model

sealed class FormEvent {
    data class NameChange(val name : String) : FormEvent()
    data class CountryNameChange(val name : String): FormEvent()
    data class MobileNumberChange(val number : String): FormEvent()
}