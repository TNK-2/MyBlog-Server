package com.myblog.api.controller

import com.myblog.api.domain.entity.UserEntity
import com.myblog.api.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/login")
class LoginController (
    private val authService: AuthService
) {

    @PostMapping
    fun authChk (
        httpServletRequest: HttpServletRequest
    ) : UserEntity {
        return authService.getAuthenticatedUserByToken(httpServletRequest.getParameter("accessToken"));
    }
}