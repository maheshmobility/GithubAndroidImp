package com.maheshsamples.myapplication.ui.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.maheshsamples.myapplication.data.model.Repository

@Composable
fun RepositoryDetailScreen(repository: Repository) {
    Column(modifier = Modifier.padding(16.dp)) {
        // Owner's Avatar
        Image(
            painter = rememberImagePainter(repository.owner.avatarUrl),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )

        // Repository Name
        Text(text = repository.name, style = MaterialTheme.typography.headlineLarge)

        // Repository Description
        Text(text = repository.description ?: "No description available")

        // Additional Information
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Language: ${repository.language ?: "N/A"}")
        Text(text = "Stars: ${repository.stargazers_count}")
        Text(text = "Forks: ${repository.forks_count}")
        Text(text = "Last Updated: ${repository.updatedAt}")
    }
}