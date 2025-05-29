package com.yourself.yourdictionary.service.impl

import com.yourself.yourdictionary.dto.phrase.CreatePhraseDTO
import com.yourself.yourdictionary.dto.phrase.PhraseDTO
import com.yourself.yourdictionary.mapper.PhraseMapper
import com.yourself.yourdictionary.repository.PhraseRepository
import com.yourself.yourdictionary.service.PhraseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class PhraseServiceImpl(
    private val phraseRepository: PhraseRepository,
    private val phraseMapper: PhraseMapper,
) : PhraseService {

    override fun create(dto: CreatePhraseDTO): PhraseDTO {
        return dto
            .let(phraseMapper::toEntity)
            .let(phraseRepository::save)
            .let(phraseMapper::toDto)
    }

    override fun getAll(pageable: Pageable): Page<PhraseDTO> {
        return phraseRepository.findAll(pageable)
            .map { phraseMapper.toDto(it) }
    }
}