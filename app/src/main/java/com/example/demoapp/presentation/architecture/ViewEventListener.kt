package com.example.demoapp.presentation.architecture

interface ViewEvent

interface ViewEventListener<TypeOfViewEvent: ViewEvent> {
    fun onEvent(event: TypeOfViewEvent)
    fun onEventDebounced(event: TypeOfViewEvent)
    fun TypeOfViewEvent.push()
}