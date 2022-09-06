package com.example.demoapp.architecture

import kotlinx.coroutines.flow.StateFlow

interface ViewState

interface ViewStateSender<TypeOfViewState: ViewState> {
    val viewState: StateFlow<TypeOfViewState?>
}