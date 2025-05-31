package com.yourself.yourdictionary.bot.command

import com.yourself.yourdictionary.dto.phrase.CreatePhraseDTO
import com.yourself.yourdictionary.dto.translation.CreateTranslationDTO
import com.yourself.yourdictionary.service.PhraseService
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update


@Component
class CreatePhraseCommand(
    private val phraseService: PhraseService
) : BotCommand {

    override fun getDescription(): String = "/create – создать новую фразу"

    override fun supports(text: String): Boolean {
        return text.startsWith("/create", ignoreCase = true)
    }

    override fun handle(update: Update): String {
        val lines = update.message.text.lines().map { it.trim() }

        if (lines.isEmpty() || lines[0].isBlank()) {
            return "❌ Пожалуйста, укажите фразу для создания. Пример:\n" +
                    "/create Hello, world!\nru: Привет\nth: สวัสดี\nnote: Пример фразы"
        }

        val englishText = lines.getOrNull(0)?.removePrefix("/create")?.trim()
        val translations = mutableListOf<CreateTranslationDTO>()
        var note: String? = null

        for (line in lines.drop(1)) {
            when {
                line.startsWith("note:", ignoreCase = true) -> {
                    note = line.removePrefix("note:").trim()
                }

                ":" in line -> {
                    val (lang, text) = line.split(":", limit = 2)
                    translations.add(
                        CreateTranslationDTO(
                            language = lang.trim(),
                            translatedText = text.trim()
                        )
                    )
                }
            }
        }

        if (englishText.isNullOrBlank()) {
            return "❌ Английская фраза не указана."
        }

        return try {
            phraseService.create(
                CreatePhraseDTO(
                    englishText = englishText,
                    note = note,
                    translations = translations
                )
            )
            "✅ Фраза успешно добавлена!"
        } catch (e: Exception) {
            "❌ Ошибка при добавлении фразы: ${e.message}"
        }
    }
}
