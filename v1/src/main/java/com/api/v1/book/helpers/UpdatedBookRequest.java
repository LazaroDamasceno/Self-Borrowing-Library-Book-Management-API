package com.api.v1.book.helpers;

import jakarta.validation.constraints.NotBlank;

public record UpdatedBookRequest(
        @NotBlank String title,
        String subtitle,
        @NotBlank String author,
        @NotBlank String field,
        @NotBlank int numberOfPages,
        @NotBlank int version,
        @NotBlank String description
) {
}
