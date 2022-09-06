package com.example.demoapp.presentation.home

import androidx.lifecycle.viewModelScope
import com.example.demoapp.architecture.BaseRoutingViewModel
import com.example.demoapp.presentation.MainDestination
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
        pushState(HomeScreenViewState.Standby())
    }

    override fun onRouterAttached() {} // No-op

    override fun onEvent(event: HomeScreenViewEvent) {
        viewModelScope.launch {
            when (event) {
                is HomeScreenViewEvent.TextFieldValueChanged -> {
                    onTextFieldValueChanged(event)
                }
                else -> {}
            }
        }
    }

    private fun onTextFieldValueChanged(event: HomeScreenViewEvent.TextFieldValueChanged) {

    }
}