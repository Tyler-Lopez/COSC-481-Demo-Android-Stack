package com.example.demoapp.presentation.all_names

import com.example.demoapp.architecture.ViewEvent
import com.example.demoapp.architecture.ViewState

sealed class AllNamesViewEvent : ViewEvent {

}

sealed class AllNamesViewState : ViewState {
    data class Standby(val names: List<String>) : AllNamesViewState()
}