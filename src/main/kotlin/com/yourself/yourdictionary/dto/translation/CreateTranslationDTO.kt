package com.yourself.yourdictionary.dto.translation

data class CreateTranslationDTO(
    val language: String,       // Например: "ru", "th"
    val translatedText: String, // Текст перевода
    val note: String? = null    // Опционально, комментарий
)
