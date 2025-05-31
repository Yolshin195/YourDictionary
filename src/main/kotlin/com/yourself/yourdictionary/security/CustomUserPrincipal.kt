package com.yourself.yourdictionary.security

import com.yourself.yourdictionary.entity.UserProfileEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserPrincipal(
    private val user: UserProfileEntity
) : UserDetails {

    fun getUser(): UserProfileEntity = user

    override fun getUsername(): String = user.username

    override fun getPassword(): String? = user.hashPassword

    override fun getAuthorities(): Collection<GrantedAuthority> = emptyList()

    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    override fun isEnabled(): Boolean = true
}