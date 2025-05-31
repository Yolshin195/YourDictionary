package com.yourself.yourdictionary.mapper

import com.yourself.yourdictionary.dto.user.CreateTelegramUserDTO
import com.yourself.yourdictionary.dto.user.UserProfileDTO
import com.yourself.yourdictionary.entity.UserProfileEntity
import org.mapstruct.Mapper


@Mapper(componentModel = "spring")
interface UserProfileMapper {
    fun telegramUserToEntity(dto: CreateTelegramUserDTO): UserProfileEntity
    fun toDto(entity: UserProfileEntity): UserProfileDTO
}