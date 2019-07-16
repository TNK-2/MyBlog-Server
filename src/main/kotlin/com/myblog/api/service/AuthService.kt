package com.myblog.api.service

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
}