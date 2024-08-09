package com.api.v1.book.helpers

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewBookRequestDto(
    @NotBlank val title: String,
    val subtitle: String,
    @NotNull @Size(min=13, max=13) val isbn: String,
    @NotBlank val publisher: String,
    @Min(1) val version: Int,
    @Min(1) val numberOfPages: Int,
    @NotBlank val author: String,
    @NotBlank val field: String
)
