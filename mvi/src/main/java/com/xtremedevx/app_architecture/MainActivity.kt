package com.xtremedevx.app_architecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.xtremedevx.app_architecture.model.FormViewModel
import com.xtremedevx.app_architecture.ui.theme.AppArchitectureTheme

class MainActivity : ComponentActivity() {
    private val formViewModel by viewModels<FormViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppArchitectureTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FormScreen(formViewModel)

                }
            }
        }
    }
}
