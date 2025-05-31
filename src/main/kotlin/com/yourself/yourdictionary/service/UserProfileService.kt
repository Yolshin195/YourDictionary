package com.yourself.yourdictionary.service

import com.yourself.yourdictionary.dto.user.CreateTelegramUserDTO
import com.yourself.yourdictionary.dto.user.CreateUserDTO
import com.yourself.yourdictionary.dto.user.UserProfileDTO
import com.yourself.yourdictionary.entity.UserProfileEntity

interface UserProfileService {
    fun createUser(dto: CreateUserDTO): UserProfileDTO
    fun getOrCreateTelegramUser(dto: CreateTelegramUserDTO): UserProfileEntity
}