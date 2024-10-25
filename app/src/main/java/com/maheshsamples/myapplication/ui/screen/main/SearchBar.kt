package com.maheshsamples.myapplication.ui.screen.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maheshsamples.myapplication.ui.theme.GitHubAPISamplesTheme

@Composable
fun SearchBar(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Search by Username") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    GitHubAPISamplesTheme {
        SearchBar(value = "google", onValueChange = {})
    }
}