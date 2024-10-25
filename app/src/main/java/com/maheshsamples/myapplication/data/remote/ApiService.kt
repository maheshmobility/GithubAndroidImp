package com.maheshsamples.myapplication.data.remote

import com.maheshsamples.myapplication.data.model.Repository
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("users/{username}/repos")
    suspend fun getRepositories(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 10
    ): List<Repository>
}