package com.example.demoapp.presentation.architecture

import kotlinx.coroutines.flow.StateFlow

interface ViewState

interface ViewStateSender<TypeOfViewState: ViewState> {
    val viewState: StateFlow<TypeOfViewState?>
}