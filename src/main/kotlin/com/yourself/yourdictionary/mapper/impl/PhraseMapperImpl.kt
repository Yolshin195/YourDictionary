package com.yourself.yourdictionary.mapper.impl

import com.yourself.yourdictionary.dto.phrase.CreatePhraseDTO
import com.yourself.yourdictionary.dto.phrase.PhraseDTO
import com.yourself.yourdictionary.dto.translation.TranslationDTO
import com.yourself.yourdictionary.entity.PhraseEntity
import com.yourself.yourdictionary.entity.TranslationEntity
import com.yourself.yourdictionary.entity.UserProfileEntity
import com.yourself.yourdictionary.mapper.PhraseMapper
import org.springframework.stereotype.Component


@Component
class PhraseMapperImpl : PhraseMapper {
    override fun toEntity(dto: CreatePhraseDTO, author: UserProfileEntity): PhraseEntity {
        val phrase = PhraseEntity(
            englishText = dto.englishText,
            note = dto.note,
            author = author
        )

        val translations = dto.translations.map {
            TranslationEntity(
                translatedText = it.translatedText,
                language = it.language,
                note = it.note,
                phrase = phrase, // важный момент!
                author = author
            )
        }

        phrase.translations.addAll(translations)

        return phrase
    }

    override fun toDto(entity: PhraseEntity): PhraseDTO {
        return PhraseDTO(
            id = entity.id,
            englishText = entity.englishText,
            note = entity.note,
            translations = entity.translations.map {
                TranslationDTO(
                    id = it.id,
                    translatedText = it.translatedText,
                    language = it.language,
                    note = it.note,
                )
            }
        )
    }
}