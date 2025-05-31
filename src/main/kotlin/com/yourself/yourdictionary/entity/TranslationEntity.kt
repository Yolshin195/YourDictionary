package com.yourself.yourdictionary.entity

import jakarta.persistence.*


@Entity
@Table(name = "translations")
data class TranslationEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "phrase_id", nullable = false)
    val phrase: PhraseEntity,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)  // связь «многие к одному», не null
    @JoinColumn(name = "author_id", nullable = false)     // колонка с FK в таблице phrases
    val author: UserProfileEntity,

    @Column(nullable = false)
    val language: String,               // 'ru', 'th', и т.д.

    @Column(nullable = false)
    val translatedText: String,

    @Column(nullable = true)
    val note: String? = null
)
