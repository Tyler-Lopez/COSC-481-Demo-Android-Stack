package com.example.demoapp.presentation.home.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.demoapp.architecture.ViewEventListener
import com.example.demoapp.presentation.home.HomeScreenViewEvent

@Composable
fun HomeScreenStandby(
    text: String,
    viewEventListener: ViewEventListener<HomeScreenViewEvent>
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("HELP")
        TextField(value = text, onValueChange = {
            viewEventListener.onEvent(
                HomeScreenViewEvent.TextFieldValueChanged(it)
            )
        })
    }
}

fun example(str: String) {
}