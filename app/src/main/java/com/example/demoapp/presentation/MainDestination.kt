package com.example.demoapp.presentation

import com.example.demoapp.architecture.Destination

sealed class MainDestination : Destination {
    data class NavigateHelloName(
        val name: String
    ): MainDestination()
    object NavigateAllNames : MainDestination()
}