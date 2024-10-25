package com.maheshsamples.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class Repository(
    val id: Long,
    val name: String,
    val description: String?,
    val language: String?,
    val stargazers_count: Int,
    val forks_count: Int,
    @SerializedName("owner") val owner: Owner,
    @SerializedName("updated_at") val updatedAt: String
)

data class Owner(
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
)