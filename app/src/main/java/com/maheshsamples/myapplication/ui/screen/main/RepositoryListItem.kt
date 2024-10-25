package com.maheshsamples.myapplication.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maheshsamples.myapplication.data.model.Repository
import com.maheshsamples.myapplication.ui.theme.GitHubAPISamplesTheme

@Composable
fun RepositoryListItem(repository: Repository) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = repository.name, maxLines = 1, overflow = TextOverflow.Ellipsis)
        Text(text = repository.description ?: "No description", maxLines = 2)
        Text(text = "Language: ${repository.language ?: "N/A"}")
        Text(text = "Stars: ${repository.stargazers_count} | Forks: ${repository.forks_count}")
    }
}

@Preview(showBackground = true)
@Composable
fun RepositoryListItemPreview() {
    GitHubAPISamplesTheme {
        RepositoryListItem(
            Repository(
                id = 1,
                name = "Sample Repository",
                description = "This is a sample repository for demonstration purposes.",
                language = "Kotlin",
                stargazers_count = 100,
                forks_count = 50,
                owner = com.maheshsamples.myapplication.data.model.Owner(
                    login = "sampleOwner",
                    avatarUrl = "https://example.com/avatar.png"
                ),
                updatedAt = "2023-01-01, 12:00:00"
            )
        )
    }
}