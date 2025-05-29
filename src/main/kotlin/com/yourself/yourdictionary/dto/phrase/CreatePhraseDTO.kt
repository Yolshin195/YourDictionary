package com.yourself.yourdictionary.dto.phrase

import com.yourself.yourdictionary.dto.translation.CreateTranslationDTO

data class CreatePhraseDTO(
    val englishText: String?,               // Английская фраза (может быть null, если пока неизвестна)
    val note: String? = null,               // Опционально, комментарий к фразе
    val translations: List<CreateTranslationDTO> = emptyList()  // Список переводов
)
