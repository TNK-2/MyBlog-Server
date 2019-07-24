package com.myblog.api.domain.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateEntryForm (
    @field:NotBlank
    @field:Size(min = 1, max = 10)
    var id: Int,

    @field:NotBlank
    @field:Size(min = 1, max = 8)
    var title: String,

    @field:NotBlank
    @field:Size(min = 1, max = 2000)
    var content: String
){}