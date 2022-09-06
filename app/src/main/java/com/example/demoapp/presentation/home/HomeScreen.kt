package com.example.demoapp.presentation.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.demoapp.presentation.home.HomeScreenViewState.*
import com.example.demoapp.presentation.home.HomeScreenViewEvent.*
import com.example.demoapp.presentation.home.composables.HomeScreenStandby

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    viewModel.viewState.collectAsState().value?.apply {
        when (this) {
            is Standby -> HomeScreenStandby(
                text = name
            )
        }
    }
}