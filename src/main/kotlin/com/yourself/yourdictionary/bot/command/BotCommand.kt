package com.yourself.yourdictionary.bot.command

import org.telegram.telegrambots.meta.api.objects.Update


interface BotCommand {
    fun supports(text: String): Boolean
    fun handle(update: Update): String
    fun getDescription(): String
}