package com.yourself.yourdictionary.bot

import com.yourself.yourdictionary.bot.command.BotCommand
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class BotCommandHandler(
    private val commands: List<BotCommand>,
) {
    fun handle(update: Update): String {
        val text = update.message.text
        val command = commands.find { it.supports(text) }
        return command?.handle(update) ?: "❓ Неизвестная команда. Введите /help для списка команд."
    }
}