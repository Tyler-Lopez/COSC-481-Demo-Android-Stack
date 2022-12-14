package com.example.demoapp.presentation.home

import androidx.lifecycle.viewModelScope
import com.example.demoapp.presentation.architecture.BaseRoutingViewModel
import com.example.demoapp.presentation.MainDestination
import com.example.demoapp.presentation.MainDestination.*
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

    private var name: String = String()

    init {
        pushState(Standby(name))
    }

    override fun onRouterAttached() {} // No-op

    override fun onEvent(event: HomeScreenViewEvent) {
        viewModelScope.launch {
            when (event) {
                is AddNameClicked -> onAddNameClicked()
                is SeeNamesClicked -> onSeeUsersClicked()
                is TextFieldValueChanged -> onTextFieldValueChanged(event)
            }
        }
    }

    private fun onAddNameClicked() {
        // TODO, put more logic validating invalid name here with err message
        if (name.isNotEmpty()) {
            routeTo(NavigateHelloName(name))
        }
    }

    private fun onSeeUsersClicked() {
        routeTo(NavigateAllNames)
    }

    private fun onTextFieldValueChanged(event: TextFieldValueChanged) {
        // TODO, put logic here preventing bad names
        name = event.value
        pushState(Standby(name = name))
    }
}