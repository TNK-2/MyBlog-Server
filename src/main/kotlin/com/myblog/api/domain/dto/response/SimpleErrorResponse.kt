package com.myblog.api.domain.dto.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class SimpleErrorResponse(
    val code: Int,
    val message: String
) {
    companion object {
        fun createForbiddenResponse(message: String): ResponseEntity<SimpleErrorResponse> {
            return ResponseEntity(
                SimpleErrorResponse(HttpStatus.FORBIDDEN.value(), message),
                HttpStatus.FORBIDDEN
            )
        }
        fun createBadRequestBodyResponse(message: String): ResponseEntity<SimpleErrorResponse> {
            return ResponseEntity(
                SimpleErrorResponse(HttpStatus.BAD_REQUEST.value(), message),
                HttpStatus.BAD_REQUEST
            )
        }
        fun createNotFoundResponse(message: String): ResponseEntity<SimpleErrorResponse> {
            return ResponseEntity(
                SimpleErrorResponse(HttpStatus.NOT_FOUND.value(), message),
                HttpStatus.NOT_FOUND
            )
        }
        fun createMethodNotAllowedResponse(message: String): ResponseEntity<SimpleErrorResponse> {
            return ResponseEntity(
                SimpleErrorResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), message),
                HttpStatus.METHOD_NOT_ALLOWED
            )
        }
        fun createInternalServerErrorResponse(message: String): ResponseEntity<SimpleErrorResponse> {
            return ResponseEntity(
                SimpleErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), message),
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
}