package com.yourself.yourdictionary.repository

import com.yourself.yourdictionary.entity.PhraseEntity
import com.yourself.yourdictionary.entity.UserProfileEntity
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph

interface PhraseRepository : JpaRepository<PhraseEntity, Long> {

    @EntityGraph(attributePaths = ["translations"])
    fun findAllByAuthor(author: UserProfileEntity, pageable: Pageable): Page<PhraseEntity>
}