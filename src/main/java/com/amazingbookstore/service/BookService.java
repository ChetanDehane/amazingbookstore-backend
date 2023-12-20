package com.amazingbookstore.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.amazingbookstore.dto.BookDto;
import com.amazingbookstore.model.Book;
import com.amazingbookstore.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	private final ModelMapper modelMapper;

	public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
		this.bookRepository = bookRepository;
		this.modelMapper = modelMapper;
	}

	public List<BookDto> getBooks() {
		Iterable<Book> all = bookRepository.findAll();
		return StreamSupport.stream(all.spliterator(), false).map(convertBookModelToBookDto())
				.collect(Collectors.toList());

	}

	private Function<? super Book, ? extends BookDto> convertBookModelToBookDto() {
		return book -> modelMapper.map(book, BookDto.class);
	}

}
