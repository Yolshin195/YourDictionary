package com.yourself.yourdictionary.service

import com.yourself.yourdictionary.entity.UserProfileEntity

interface CurrentUserService {
    fun getCurrentUser(): UserProfileEntity
}