package com.amazingbookstore.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.amazingbookstore.dto.BookDto;
import com.amazingbookstore.model.Book;
import com.amazingbookstore.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@InjectMocks
	private BookService bookService;

	@Mock
	private BookRepository bookRepository;

	@Mock
	private ModelMapper mapper;

	@Test
	void shouldReturnListOfBookDtoWhenGetBooksCalled() {
		List<Book> books = new ArrayList<>();
		Book book = getBook();
		books.add(book);
		BookDto bookDto = getBookDto();
		when(bookRepository.findAll()).thenReturn(books);
		when(mapper.map(book, BookDto.class)).thenReturn(bookDto);
		List<BookDto> bookDtos = bookService.getBooks();
		assertThat(1).isEqualTo(bookDtos.size());
		assertThat(bookDtos.get(0)).isNotNull().hasFieldOrPropertyWithValue("title", "test title")
				.hasFieldOrPropertyWithValue("description", "test description")
				.hasFieldOrPropertyWithValue("releaseYear", 2023);

	}

	private Book getBook() {
		return Book.builder().title("test title").description("test description").id(UUID.randomUUID())
				.releaseYear(2023).build();
	}

	private BookDto getBookDto() {
		return BookDto.builder().title("test title").description("test description").id(UUID.randomUUID())
				.releaseYear(2023).build();
	}

}
