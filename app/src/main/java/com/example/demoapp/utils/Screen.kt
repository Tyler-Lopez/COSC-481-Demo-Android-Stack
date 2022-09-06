package com.example.demoapp.utils

sealed class Screen(val route: String) {
    object AllNames : Screen("AllNames")
    object HelloName : Screen("HelloName")
    object Home : Screen("Home")
}
