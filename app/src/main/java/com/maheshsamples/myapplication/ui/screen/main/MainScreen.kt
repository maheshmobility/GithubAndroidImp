package com.maheshsamples.myapplication.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maheshsamples.myapplication.ui.theme.GitHubAPISamplesTheme
import com.maheshsamples.myapplication.viewmodel.MainViewModel

@Composable
fun MainScreen(modifier: Modifier, viewModel: MainViewModel = viewModel()) {

    var username by remember { mutableStateOf("google") }
    var selectedLanguage by remember { mutableStateOf("") }

    val repositories = viewModel.repositories.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Search Bar
        SearchBar(username) {
            username = it
            viewModel.resetAndLoadRepositories(username)
        }

        // Language Filter Dropdown
        LanguageFilterDropdown(selectedLanguage) { language ->
            selectedLanguage = language
            viewModel.filterRepositoriesByLanguage(language)
        }

        // Error Handling UI
        if (errorMessage != null) {
            ErrorMessageUI(errorMessage) {
                viewModel.loadRepositories(username)
            }
        } else {
            // Repository List
            LazyColumn {
                items(repositories.size) { index ->
                    RepositoryListItem(repository = repositories[index])
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    GitHubAPISamplesTheme {
        MainScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}