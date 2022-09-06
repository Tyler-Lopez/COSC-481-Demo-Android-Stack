package com.example.demoapp.presentation.all_names

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.demoapp.presentation.all_names.composables.AllNamesStandby

@Composable
fun AllNamesScreen(
    viewModel: AllNamesViewModel = hiltViewModel()
) {
    viewModel.viewState.collectAsState().value?.apply {
        when (this) {
            is AllNamesViewState.Standby -> AllNamesStandby(names)
        }
    }
}