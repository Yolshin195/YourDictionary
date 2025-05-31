package com.yourself.yourdictionary.service.impl

import com.yourself.yourdictionary.dto.user.CreateTelegramUserDTO
import com.yourself.yourdictionary.dto.user.CreateUserDTO
import com.yourself.yourdictionary.dto.user.UserProfileDTO
import com.yourself.yourdictionary.entity.UserProfileEntity
import com.yourself.yourdictionary.mapper.UserProfileMapper
import com.yourself.yourdictionary.repository.UserProfileRepository
import com.yourself.yourdictionary.service.UserProfileService
import org.springframework.stereotype.Service

@Service
class UserProfileServiceImpl(
    private val userProfileRepository: UserProfileRepository,
    private val userProfileMapper: UserProfileMapper,
) : UserProfileService {
    override fun createUser(dto: CreateUserDTO): UserProfileDTO {
        TODO("Not yet implemented")
    }

    override fun getOrCreateTelegramUser(dto: CreateTelegramUserDTO): UserProfileEntity {
        return userProfileRepository.findByTelegramId(dto.telegramId)
            ?: userProfileRepository.saveAndFlush(
                userProfileMapper.telegramUserToEntity(dto)
            )
    }
}