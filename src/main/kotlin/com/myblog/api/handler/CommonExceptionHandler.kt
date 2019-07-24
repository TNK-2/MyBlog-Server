package com.myblog.api.handler

import com.myblog.api.domain.dto.response.SimpleErrorResponse
import com.myblog.api.domain.exception.AuthenticationException
import com.myblog.api.domain.exception.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestControllerAdvice
class CommonExceptionHandler {
    companion object {
        private val log = LoggerFactory.getLogger(CommonExceptionHandler::class.java)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(
        e: NotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<SimpleErrorResponse> {
        log.error(e.message);
        return SimpleErrorResponse.createNotFoundResponse(e.message?:"リソースが見つかりませんでした")
    }

    @ExceptionHandler(AuthenticationException::class)
    fun authenticationFailure(
        request: HttpServletRequest,
        response: HttpServletResponse,
        e: AuthenticationException
    ): ResponseEntity<SimpleErrorResponse> {
        log.warn(e.message);
        return SimpleErrorResponse.createForbiddenResponse(e.message?:"アクセスが許可されていません")
    }

    @ExceptionHandler(Exception::class)
    fun internalErrorException(e: Exception, request: HttpServletRequest): ResponseEntity<SimpleErrorResponse> {
        // その他の例外の場合のみスタックトレースをログに含める
        log.error(e.message)
        return SimpleErrorResponse.createInternalServerErrorResponse(e.message?:"サーバーエラー")
    }
}