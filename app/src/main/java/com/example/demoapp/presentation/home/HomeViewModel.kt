package com.example.demoapp.presentation.home

import com.example.demoapp.architecture.BaseRoutingViewModel
import com.example.demoapp.presentation.MainDestination
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class HomeViewModel : BaseRoutingViewModel<
        HomeScreenViewState,
        HomeScreenViewEvent,
        MainDestination>() {

    override fun onRouterAttached() {} // No-op

    override fun onEvent(event: HomeScreenViewEvent) {
        TODO("Not yet implemented")
    }
}