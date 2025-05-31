package com.yourself.yourdictionary.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient
import org.telegram.telegrambots.meta.generics.TelegramClient

@Configuration
class TelegramBotConfig {

    @Bean
    fun telegramClient(
        @Value("\${telegram.bot.token}") botToken: String
    ): TelegramClient {
        return OkHttpTelegramClient(botToken)
    }
}