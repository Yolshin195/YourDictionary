package com.yourself.yourdictionary.repository

import com.yourself.yourdictionary.entity.PhraseEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PhraseRepository : JpaRepository<PhraseEntity, Long> {
}