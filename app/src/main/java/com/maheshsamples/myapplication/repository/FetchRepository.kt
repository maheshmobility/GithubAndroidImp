package com.maheshsamples.myapplication.repository

import com.maheshsamples.myapplication.data.model.Repository
import com.maheshsamples.myapplication.data.remote.ApiClient

class FetchRepository {
    private val apiService = ApiClient.apiService

    suspend fun getRepositories(username: String, page: Int): List<Repository> {
        return apiService.getRepositories(username, page)
    }
}