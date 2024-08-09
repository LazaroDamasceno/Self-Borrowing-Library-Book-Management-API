package com.api.v1.book.dtos

data class BookResponseDto(
    val fullTitle: String,
    val isbn: String,
    val publisher: String,
    val publishingYear: String,
    val version: Int,
    val numberOfPages: Int,
    val author: String,
    val field: String,
    val addedAt: String,
    val updatedAt: String
)
