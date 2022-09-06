package com.example.demoapp.presentation.home

import com.example.demoapp.architecture.ViewEvent
import com.example.demoapp.architecture.ViewState

sealed class HomeScreenViewEvent : ViewEvent {
    object AddNameClicked : HomeScreenViewEvent()
    object SeeNamesClicked : HomeScreenViewEvent()
    data class TextFieldValueChanged(
        val value: String
    ) : HomeScreenViewEvent()
}

sealed class HomeScreenViewState : ViewState {
    data class Standby(
        val name: String = ""
    ) : HomeScreenViewState()
}