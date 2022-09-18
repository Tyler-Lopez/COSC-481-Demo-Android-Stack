package com.example.demoapp.presentation.all_names

import com.example.demoapp.presentation.architecture.ViewEvent
import com.example.demoapp.presentation.architecture.ViewState

sealed class AllNamesViewEvent : ViewEvent {

}

sealed class AllNamesViewState : ViewState {
    object Loading : AllNamesViewState()
    data class Standby(val names: List<String>) : AllNamesViewState()
}