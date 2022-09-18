package com.example.demoapp.presentation.architecture

import kotlinx.coroutines.flow.StateFlow

interface RoutingViewModel<
        TypeOfViewState : ViewState,
        TypeOfViewEvent : ViewEvent,
        TypeOfDestination : Destination> :
    ViewEventListener<TypeOfViewEvent>, ViewStateSender<TypeOfViewState> {

    // TODO, these overrides only exist to provide comments for each aggregated function
    override val viewState: StateFlow<TypeOfViewState?>

    fun attachRouter(router: Router<TypeOfDestination>)

    fun onRouterAttached()

    override fun onEvent(event: TypeOfViewEvent)

    override fun onEventDebounced(event: TypeOfViewEvent)

    override fun TypeOfViewEvent.push()

    fun pushState(state: TypeOfViewState)

    fun TypeOfViewState.push()

    fun routeTo(destination: TypeOfDestination)

    fun TypeOfDestination.route()
}