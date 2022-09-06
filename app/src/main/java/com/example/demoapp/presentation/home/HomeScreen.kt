package com.example.demoapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.demoapp.architecture.Router
import com.example.demoapp.presentation.MainDestination
import com.example.demoapp.presentation.home.HomeScreenViewState.Standby
import com.example.demoapp.presentation.home.composables.HomeScreenStandby

@Composable
fun HomeScreen(
    router: Router<MainDestination>,
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(router) { viewModel.attachRouter(router) }
    viewModel.viewState.collectAsState().value?.apply {
        when (this) {
            is Standby -> HomeScreenStandby(
                text = name,
                viewEventListener = viewModel
            )
        }
    }
}