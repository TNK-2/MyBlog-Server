package com.myblog.api.domain.exception

import org.springframework.validation.FieldError

class ValidationException(var errorList: List<FieldError>) : RuntimeException()