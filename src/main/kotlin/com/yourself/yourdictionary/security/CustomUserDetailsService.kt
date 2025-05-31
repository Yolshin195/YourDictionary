package com.yourself.yourdictionary.security

import com.yourself.yourdictionary.repository.UserProfileRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userProfileRepository: UserProfileRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userProfileRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found: $username")

        if (user.hashPassword.isNullOrBlank()) {
            throw UsernameNotFoundException("User does not have a password set: $username")
        }

        return CustomUserPrincipal(user)
    }
}