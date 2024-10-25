package com.maheshsamples.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maheshsamples.myapplication.data.model.Repository
import com.maheshsamples.myapplication.repository.FetchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = FetchRepository()

    private val _repositories = MutableStateFlow<List<Repository>>(emptyList())
    val repositories: StateFlow<List<Repository>> = _repositories

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private var page = 1

    fun loadRepositories(username: String) {
        viewModelScope.launch {
            try {
                val newRepos = repository.getRepositories(username, page)
                _repositories.value += newRepos
                page++
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun resetAndLoadRepositories(username: String) {
        _repositories.value = emptyList()
        page = 1
        loadRepositories(username)
    }

    fun filterRepositoriesByLanguage(language: String) {
        _repositories.value = _repositories.value.filter {
            it.language == language || language.isEmpty()
        }
    }
}