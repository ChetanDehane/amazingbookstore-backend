package com.amazingbookstore.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "BookDto", description = "All details about book")
public class BookDto {

    @Schema(
        name = "id",
        readOnly = true,
        description = "The database generated uuid for book id",
        example = "3fa85f64-5717-4562-b3fc-2c963f66afa6",
        required = true
    )
    private UUID id;

    @Schema(
        name = "title",
        readOnly = true,
        description = "Book title",
        example = "Book title",
        required = true
    )
    private String title;

    @Schema(
        name = "description",
        readOnly = true,
        description = "Book Description",
        example = "Book Description",
        required = true
    )
    private String description;

    @Schema(
        name = "releaseYear",
        readOnly = true,
        description = "Book Release Year",
        example = "2023",
        required = true
    )
    private int releaseYear;
}
