package com.example.kmp.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmp.Platform

@Composable
fun AboutScreen() {
    Column {
        Toolbar()
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(title = {
        Text(text = "About Device")
    })
}


@Composable
fun ContentView() {
    val items = makeItems()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items,
        ) {
            RowView(title = it.first, subtitle = it.second)
        }
    }
}

@Composable
fun RowView(title: String, subtitle: String) {
    Column(
        Modifier.padding(8.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.bodySmall)
        Text(text = subtitle, style = MaterialTheme.typography.bodyLarge)
        Divider()
    }
}

fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair(
            "Density", "${
                platform.density
            }"
        )
    )
}

@Preview
@Composable
fun AboutScreenPreview() {
    MyApplicationTheme {
        Column {
            Toolbar()
            ContentView()
            RowView(title = "Test Title", subtitle = "Subtitle")
        }
    }
}

