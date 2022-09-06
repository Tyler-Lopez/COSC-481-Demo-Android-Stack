package com.example.demoapp.presentation.hello_name

import androidx.lifecycle.SavedStateHandle
import com.example.demoapp.architecture.BaseRoutingViewModel
import com.example.demoapp.presentation.MainDestination
import com.example.demoapp.presentation.home.HomeScreenViewEvent
import com.example.demoapp.presentation.home.HomeScreenViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HelloNameViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseRoutingViewModel<
        HelloNameViewState,
        HelloNameViewEvent,
        MainDestination>() {

    init {
        // Todo, insert into Firestore
        pushState(
            HelloNameViewState.Standby(
                name = savedStateHandle["name"] ?: error("Name not found.")
            )
        )
    }

    override fun onRouterAttached() {} // No-op

    override fun onEvent(event: HelloNameViewEvent) {
    }
}