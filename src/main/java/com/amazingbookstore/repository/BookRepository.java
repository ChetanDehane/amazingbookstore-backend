package com.amazingbookstore.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.amazingbookstore.model.Book;

public interface BookRepository extends CrudRepository<Book, UUID> {
	List<Book> findBooksByTitle(String title);
}
