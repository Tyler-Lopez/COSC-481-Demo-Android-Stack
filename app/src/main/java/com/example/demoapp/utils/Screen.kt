package com.example.demoapp.utils

sealed class Screen(val route: String) {
    object Home : Screen("Home")
}
