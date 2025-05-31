package com.yourself.yourdictionary.service.impl

import com.yourself.yourdictionary.entity.UserProfileEntity
import com.yourself.yourdictionary.security.CustomUserPrincipal
import com.yourself.yourdictionary.service.CurrentUserService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service


@Service
class SpringSecurityCurrentUserService : CurrentUserService {
    override fun getCurrentUser(): UserProfileEntity {
        val auth = SecurityContextHolder.getContext().authentication
        val principal = auth?.principal
        if (principal is CustomUserPrincipal) {
            return principal.getUser()
        } else {
            throw IllegalStateException("Unknown principal type or not authenticated")
        }
    }
}