package com.yourself.yourdictionary.dto.user

data class UserProfileDTO(
    val id: Long,
    val username: String,
    val email: String? = null,
    val telegramId: String? = null,
)
