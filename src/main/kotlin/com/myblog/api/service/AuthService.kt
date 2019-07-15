package com.myblog.api.service

import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class AuthService {

    fun isAuthenticated(identifyKey: String?): Boolean {
        return true
    }
}