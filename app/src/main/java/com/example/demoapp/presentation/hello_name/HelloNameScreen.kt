package com.example.demoapp.presentation.hello_name

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.demoapp.presentation.hello_name.composables.HelloNameStandby

@Composable
fun HelloNameScreen(viewModel: HelloNameViewModel = hiltViewModel()) {
    viewModel.viewState.collectAsState().value?.apply {
        when (this) {
            is HelloNameViewState.Standby -> HelloNameStandby(name)
        }
    }
}