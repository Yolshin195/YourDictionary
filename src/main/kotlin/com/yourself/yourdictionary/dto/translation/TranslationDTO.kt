package com.yourself.yourdictionary.dto.translation

data class TranslationDTO(
    val id: Long,
    val language: String,       // Например: "ru", "th"
    val translatedText: String, // Текст перевода
    val note: String? = null    // Опционально, комментарий
)
