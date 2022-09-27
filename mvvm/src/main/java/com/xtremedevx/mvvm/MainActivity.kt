package com.xtremedevx.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.xtremedevx.mvvm.screen.FormScreen
import com.xtremedevx.mvvm.ui.theme.AppArchitectureTheme
import com.xtremedevx.mvvm.viewmodel.FormViewModel

class MainActivity : ComponentActivity() {
    private val formViewModel by viewModels<FormViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppArchitectureTheme {
                FormScreen(formViewModel)
            }
        }
    }
}