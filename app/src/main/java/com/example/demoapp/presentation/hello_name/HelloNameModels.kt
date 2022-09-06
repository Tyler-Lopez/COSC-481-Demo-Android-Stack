package com.example.demoapp.presentation.hello_name

import com.example.demoapp.architecture.ViewEvent
import com.example.demoapp.architecture.ViewState

sealed class HelloNameViewEvent : ViewEvent {
}

sealed class HelloNameViewState : ViewState {
    data class Standby(
        val name: String
    ) : HelloNameViewState()
}