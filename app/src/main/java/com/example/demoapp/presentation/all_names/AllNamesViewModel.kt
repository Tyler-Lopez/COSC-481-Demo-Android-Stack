package com.example.demoapp.presentation.all_names

import androidx.lifecycle.viewModelScope
import com.example.demoapp.presentation.architecture.BaseRoutingViewModel
import com.example.demoapp.domain.usecase.GetUsersUseCase
import com.example.demoapp.presentation.MainDestination
import com.example.demoapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllNamesViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : BaseRoutingViewModel<
        AllNamesViewState,
        AllNamesViewEvent,
        MainDestination>() {

    init {
        pushState(AllNamesViewState.Loading)
        viewModelScope.launch {
            (getUsersUseCase() as? Resource.Success)?.let {
                pushState(
                    AllNamesViewState.Standby(
                        it.data.map { user -> user.name }
                    )
                )
            }
        }
    }

    override fun onRouterAttached() {} // No-op

    override fun onEvent(event: AllNamesViewEvent) {
        TODO("Not yet implemented")
    }
}