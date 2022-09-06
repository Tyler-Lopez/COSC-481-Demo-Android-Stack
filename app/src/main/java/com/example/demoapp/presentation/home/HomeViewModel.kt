package com.example.demoapp.presentation.home

import androidx.lifecycle.viewModelScope
import com.example.demoapp.architecture.BaseRoutingViewModel
import com.example.demoapp.presentation.MainDestination
import com.example.demoapp.presentation.home.HomeScreenViewEvent.*
import com.example.demoapp.presentation.home.HomeScreenViewState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseRoutingViewModel<
        HomeScreenViewState,
        HomeScreenViewEvent,
        MainDestination>() {

    init {
        pushState(Standby())
    }

    override fun onRouterAttached() {} // No-op

    override fun onEvent(event: HomeScreenViewEvent) {
        viewModelScope.launch {
            when (event) {
                is TextFieldValueChanged -> {
                    onTextFieldValueChanged(event)
                }
                else -> {}
            }
        }
    }

    private fun onTextFieldValueChanged(event: TextFieldValueChanged) {
        // TODO, put logic here preventing bad names
        pushState(
            Standby(
                name = event.value
            )
        )
    }
}