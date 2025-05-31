package com.yourself.yourdictionary.bot.command

import com.yourself.yourdictionary.bot.TelegramUserContext
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class StartCommand(
    private val userContext: TelegramUserContext,
) : BotCommand {

    override fun supports(text: String) = text.startsWith("/start", ignoreCase = true)

    override fun handle(update: Update): String {
        val user = userContext.getCurrentUser()

        return "Привет, ${user.username}! Добро пожаловать в YourDictionaryBot ✨"
    }

    override fun getDescription(): String = "/start – старт"
}