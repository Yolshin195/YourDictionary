package com.yourself.yourdictionary.bot

import com.yourself.yourdictionary.entity.UserProfileEntity

object TelegramUserContextHolder {
    private val currentUser = ThreadLocal<UserProfileEntity>()

    fun isSet(): Boolean = currentUser.get() != null

    fun set(user: UserProfileEntity) {
        currentUser.set(user)
    }

    fun get(): UserProfileEntity {
        return currentUser.get() ?: throw IllegalStateException("Пользователь Telegram не установлен")
    }

    fun clear() {
        currentUser.remove()
    }
}