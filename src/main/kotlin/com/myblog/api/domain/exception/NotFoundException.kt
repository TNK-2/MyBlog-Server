package com.myblog.api.domain.exception

class NotFoundException(var detailMessage: String) : RuntimeException()