package com.example.demoapp.architecture

interface ViewEvent

interface ViewEventListener<TypeOfViewEvent: ViewEvent> {
    fun onEvent(event: TypeOfViewEvent)
    fun onEventDebounced(event: TypeOfViewEvent)
}