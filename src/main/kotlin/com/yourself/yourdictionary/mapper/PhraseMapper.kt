package com.yourself.yourdictionary.mapper

import com.yourself.yourdictionary.dto.phrase.CreatePhraseDTO
import com.yourself.yourdictionary.dto.phrase.PhraseDTO
import com.yourself.yourdictionary.entity.PhraseEntity



interface PhraseMapper {
    fun toEntity(dto: CreatePhraseDTO): PhraseEntity
    fun toDto(entity: PhraseEntity): PhraseDTO
}