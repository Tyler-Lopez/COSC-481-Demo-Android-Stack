package com.example.demoapp.presentation.home.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreenStandby(
    text: String,
    //   eventReceiver: EventReceiver<HomeScreenViewEvent>
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("HELP")
        TextField(value = text, onValueChange = ::example)
    }
}

fun example(str: String) {
}