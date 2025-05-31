package com.yourself.yourdictionary.service.impl

import com.yourself.yourdictionary.bot.TelegramUserContextHolder
import com.yourself.yourdictionary.entity.UserProfileEntity
import com.yourself.yourdictionary.service.CurrentUserService
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
@Primary
class DelegatingCurrentUserService(
    private val telegramCurrentUserService: TelegramCurrentUserService,
    private val securityCurrentUserService: SpringSecurityCurrentUserService,
) : CurrentUserService {

    override fun getCurrentUser(): UserProfileEntity {
        return if (TelegramUserContextHolder.isSet()) {
            telegramCurrentUserService.getCurrentUser()
        } else {
            securityCurrentUserService.getCurrentUser()
        }
    }
}