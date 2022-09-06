package com.example.demoapp.presentation.home

import androidx.lifecycle.SavedStateHandle
import com.example.demoapp.architecture.BaseRoutingViewModel
import com.example.demoapp.presentation.MainDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseRoutingViewModel<
        HomeScreenViewState,
        HomeScreenViewEvent,
        MainDestination>() {

    override fun onRouterAttached() {} // No-op

    override fun onEvent(event: HomeScreenViewEvent) {
        TODO("Not yet implemented")
    }
}