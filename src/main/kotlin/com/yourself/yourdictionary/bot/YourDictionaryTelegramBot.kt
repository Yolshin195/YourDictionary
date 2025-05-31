package com.yourself.yourdictionary.bot

import org.telegram.telegrambots.meta.api.objects.Update
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.generics.TelegramClient

@Component
class YourDictionaryTelegramBot(
    private val telegramClient: TelegramClient,
    private val botCommandHandler: BotCommandHandler,
    private val telegramUserContext: TelegramUserContext,
    @Value("\${telegram.bot.token}") private val botToken: String,
) : SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {
    override fun getBotToken(): String {
        return botToken
    }

    override fun getUpdatesConsumer(): LongPollingUpdateConsumer {
        return this
    }

    override fun consume(update: Update?) {
        if (update == null || !update.hasMessage() || !update.message.hasText()) return

        try {
            telegramUserContext.authenticateFromUpdate(update)
            val responseText = botCommandHandler.handle(update)
            sendMessage(update.message.chatId, responseText)
        } finally {
            telegramUserContext.clear()
        }
    }

    private fun sendMessage(chatId: Long, text: String) {
        try {
            val message = SendMessage(chatId.toString(), text)
            telegramClient.execute(message)
        } catch (e: Exception) {
            println("Ошибка при отправке сообщения: ${e.message}")
        }
    }
}
