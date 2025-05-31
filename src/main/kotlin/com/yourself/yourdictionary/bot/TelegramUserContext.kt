package com.yourself.yourdictionary.bot

import com.yourself.yourdictionary.dto.user.CreateTelegramUserDTO
import com.yourself.yourdictionary.entity.UserProfileEntity
import com.yourself.yourdictionary.service.UserProfileService
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update

@Component
@Scope("prototype") // чтобы в каждом обновлении был свой контекст
class TelegramUserContext(
    private val userProfileService: UserProfileService
) {
    /**
     * Авторизует пользователя из Telegram update и кладёт в ThreadLocal-хранилище
     */
    fun authenticateFromUpdate(update: Update): UserProfileEntity {
        val telegramUser = update.message.from
        val telegramId = telegramUser.id.toString()
        val username = telegramUser.userName ?: "пользователь"

        val userEntity = userProfileService.getOrCreateTelegramUser(
            CreateTelegramUserDTO(telegramId = telegramId, username = username)
        )

        TelegramUserContextHolder.set(userEntity)
        return userEntity
    }

    /**
     * Получить текущего авторизованного пользователя из ThreadLocal
     */
    fun getCurrentUser(): UserProfileEntity {
        return TelegramUserContextHolder.get()
    }

    /**
     * Очистить ThreadLocal-хранилище (желательно вызывать после обработки update)
     */
    fun clear() {
        TelegramUserContextHolder.clear()
    }
}