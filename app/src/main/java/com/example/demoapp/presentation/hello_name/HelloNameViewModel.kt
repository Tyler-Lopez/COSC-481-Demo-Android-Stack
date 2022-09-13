package com.example.demoapp.presentation.hello_name

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.demoapp.architecture.BaseRoutingViewModel
import com.example.demoapp.domain.usecase.InsertUsersUseCase
import com.example.demoapp.presentation.MainDestination
import com.example.demoapp.presentation.home.HomeScreenViewEvent
import com.example.demoapp.presentation.home.HomeScreenViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HelloNameViewModel @Inject constructor(
    private val insertUsersUseCase: InsertUsersUseCase,
    savedStateHandle: SavedStateHandle
) : BaseRoutingViewModel<
        HelloNameViewState,
        HelloNameViewEvent,
        MainDestination>() {

    init {
        val name: String = savedStateHandle["name"] ?: error("Name not found.")
        // Todo, insert into Firestore
        pushState(
            HelloNameViewState.Standby(
                name = name
            )
        )
        viewModelScope.launch {
            insertUsersUseCase(name = name)
        }
    }

    override fun onRouterAttached() {} // No-op

    override fun onEvent(event: HelloNameViewEvent) {
    }
}