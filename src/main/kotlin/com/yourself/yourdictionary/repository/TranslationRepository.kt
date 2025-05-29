package com.yourself.yourdictionary.repository

import com.yourself.yourdictionary.entity.TranslationEntity
import org.springframework.data.repository.CrudRepository

interface TranslationRepository : CrudRepository<TranslationEntity, Long> {
}