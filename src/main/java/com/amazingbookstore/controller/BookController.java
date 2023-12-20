package com.amazingbookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazingbookstore.dto.BookDto;
import com.amazingbookstore.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book Api", description = "Book Controller")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Operation(summary = "get list of books")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrived list of book"),
			@ApiResponse(responseCode = "403", description = "The resource you are trying to access is forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found")
	})
	
	@GetMapping
	public ResponseEntity<List<BookDto>> getBooks() {

		List<BookDto> books = bookService.getBooks();
		return ResponseEntity.ok(books);

	}

}
