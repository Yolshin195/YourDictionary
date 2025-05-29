package com.yourself.yourdictionary.listener

import com.yourself.yourdictionary.service.PhraseService
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component


@Component
class PhraseQueueListener(
    private val phraseService: PhraseService
) {

    @JmsListener(destination = "phrase.create.queue")
    fun processCreatePhrase(text: String) {
        // Можно добавить логирование успешной обработки
        println("Фраза успешно создана через очередь: $text")
    }
}