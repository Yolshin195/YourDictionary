package com.yourself.yourdictionary.service

import com.yourself.yourdictionary.dto.phrase.CreatePhraseDTO
import com.yourself.yourdictionary.dto.phrase.PhraseDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PhraseService {
    fun create(dto: CreatePhraseDTO): PhraseDTO
    fun getAll(pageable: Pageable): Page<PhraseDTO>
}