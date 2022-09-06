package com.example.demoapp.presentation.home.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.demoapp.R
import com.example.demoapp.architecture.ViewEventListener
import com.example.demoapp.presentation.home.HomeScreenViewEvent
import com.example.demoapp.presentation.home.HomeScreenViewEvent.*

@Composable
fun HomeScreenStandby(
    text: String,
    viewEventListener: ViewEventListener<HomeScreenViewEvent>
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(value = text, onValueChange = {
            viewEventListener.onEvent(
                TextFieldValueChanged(it)
            )
        })
        Button(onClick = {
            viewEventListener.onEventDebounced(
                AddNameClicked
            )
        }) {
            Text(stringResource(R.string.button_add_name_text))
        }
        Button(onClick = {
            viewEventListener.onEventDebounced(
                SeeNamesClicked
            )
        }) {
            Text(stringResource(R.string.button_all_names_text))
        }
    }
}