package com.myblog.api.domain.repository

import com.myblog.api.domain.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Int>{
    fun findByAccessTokenAndDeleteFlagFalse(accessToken: String): UserEntity?
}