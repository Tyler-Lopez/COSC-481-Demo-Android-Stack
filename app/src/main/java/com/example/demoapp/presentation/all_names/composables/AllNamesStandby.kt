package com.example.demoapp.presentation.all_names.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun AllNamesStandby(
    names: List<String>
) {
    LazyColumn {
        items(count = names.size) {
            Text(names[it])
        }
    }
}