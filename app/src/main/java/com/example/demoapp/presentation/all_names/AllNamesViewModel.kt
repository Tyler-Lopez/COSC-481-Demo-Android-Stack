package com.example.demoapp.presentation.all_names

import com.example.demoapp.architecture.BaseRoutingViewModel
import com.example.demoapp.presentation.MainDestination
import com.example.demoapp.presentation.hello_name.HelloNameViewEvent
import com.example.demoapp.presentation.hello_name.HelloNameViewState

class AllNamesViewModel : BaseRoutingViewModel<
        AllNamesViewState,
        AllNamesViewEvent,
        MainDestination>() {

    init {
        // Todo, load from Firestore
        pushState(
            AllNamesViewState.Standby(
                listOf("Mocked Name 1", "Mocked Name 2", "Mocked Name 3")
            )
        )
    }
    override fun onRouterAttached() {} // No-op

    override fun onEvent(event: AllNamesViewEvent) {
        TODO("Not yet implemented")
    }
}