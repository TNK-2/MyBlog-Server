package com.myblog.api.service

import com.myblog.api.domain.entity.UserEntity
import com.myblog.api.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
)
{
    fun getUserByAccessToken(accessToken: String?): UserEntity? {
        accessToken ?: return null;
        return userRepository.findByAccessTokenAndDeleteFlagFalse(accessToken);
    }
}