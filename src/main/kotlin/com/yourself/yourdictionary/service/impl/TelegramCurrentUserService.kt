package com.yourself.yourdictionary.service.impl

import com.yourself.yourdictionary.bot.TelegramUserContextHolder
import com.yourself.yourdictionary.entity.UserProfileEntity
import com.yourself.yourdictionary.service.CurrentUserService
import org.springframework.stereotype.Service


@Service
class TelegramCurrentUserService: CurrentUserService {
    override fun getCurrentUser(): UserProfileEntity {
        return TelegramUserContextHolder.get()
    }
}