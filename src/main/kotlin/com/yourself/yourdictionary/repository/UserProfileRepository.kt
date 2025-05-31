package com.yourself.yourdictionary.repository

import com.yourself.yourdictionary.entity.UserProfileEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileRepository : JpaRepository<UserProfileEntity, Long> {
    fun findByTelegramId(telegramId: String): UserProfileEntity?
    fun findByUsername(username: String): UserProfileEntity?
}