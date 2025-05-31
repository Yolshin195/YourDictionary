package com.yourself.yourdictionary.entity

import jakarta.persistence.*


@Entity
    @Table(name = "user_profiles")
data class UserProfileEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val username: String,

    @Column(unique = true, nullable = true)
    val email: String? = null,

    @Column(nullable = true)
    var hashPassword: String? = null,

    @Column(unique = true, nullable = true)
    var telegramId: String? = null  // nullable и уникальный
)
