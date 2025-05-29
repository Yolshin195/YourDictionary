package com.yourself.yourdictionary.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "phrases")
data class PhraseEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = true)
    val englishText: String? = null,   // Можно оставить пустым при создании

    @Column(nullable = true)
    val note: String? = null,          // Комментарий, откуда мысль и т.д.

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "phrase", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var translations: MutableList<TranslationEntity> = mutableListOf()
)