package com.yourself.yourdictionary.bot.command

import com.yourself.yourdictionary.service.PhraseService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.Update


@Component
class GetMyPhrasesCommand(
    private val phraseService: PhraseService
) : BotCommand {

    override fun supports(text: String): Boolean {
        return text.equals("/phrases", ignoreCase = true)
    }

    override fun getDescription(): String = "/phrases – показать список фраз"

    override fun handle(update: Update): String {
        return try {
            // Получаем первые 10 фраз, отсортированные по дате создания (если есть поле такое)
            val phrasesPage = phraseService.getAll(
                PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "createdAt"))
            )

            if (phrasesPage.isEmpty) {
                "❕ У тебя пока нет сохранённых фраз."
            } else {
                buildString {
                    append("📚 Твои фразы:\n\n")
                    phrasesPage.forEach { phrase ->
                        append("• ${phrase.englishText ?: "???"}\n")
                        phrase.translations.forEach {
                            append("   - ${it.language}: ${it.translatedText}\n")
                        }
                        if (!phrase.note.isNullOrBlank()) {
                            append("   💬 ${phrase.note}\n")
                        }
                        append("\n")
                    }
                }
            }
        } catch (e: Exception) {
            "❌ Ошибка при получении фраз: ${e.message}"
        }
    }
}