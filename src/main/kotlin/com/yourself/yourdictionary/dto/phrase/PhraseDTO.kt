package com.yourself.yourdictionary.dto.phrase

import com.yourself.yourdictionary.dto.translation.TranslationDTO


data class PhraseDTO(
    val id: Long,
    val englishText: String?,               // Английская фраза (может быть null, если пока неизвестна)
    val note: String? = null,               // Опционально, комментарий к фразе
    val translations: List<TranslationDTO> = emptyList()  // Список переводов
)
