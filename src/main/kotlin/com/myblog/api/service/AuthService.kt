package com.myblog.api.service

import com.myblog.api.domain.entity.UserEntity
import com.myblog.api.domain.exception.AuthenticationException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class AuthService (
    private val userService: UserService
)
{
    fun isAuthenticated(accessToken: String?): Boolean {
        accessToken ?: return false;
        userService.getUserByAccessToken(accessToken) ?: return false
        return true;
    }

    fun getAuthenticatedUserByToken(accessToken: String?): UserEntity {
        accessToken ?: throw AuthenticationException("not authenticated");
        return userService.getUserByAccessToken(accessToken) ?: throw AuthenticationException("not authenticated");
    }
}