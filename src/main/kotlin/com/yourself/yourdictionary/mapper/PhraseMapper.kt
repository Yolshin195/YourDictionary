package com.yourself.yourdictionary.mapper

import com.yourself.yourdictionary.dto.phrase.CreatePhraseDTO
import com.yourself.yourdictionary.dto.phrase.PhraseDTO
import com.yourself.yourdictionary.entity.PhraseEntity
import com.yourself.yourdictionary.entity.UserProfileEntity


interface PhraseMapper {
    fun toEntity(dto: CreatePhraseDTO, author: UserProfileEntity): PhraseEntity
    fun toDto(entity: PhraseEntity): PhraseDTO
}