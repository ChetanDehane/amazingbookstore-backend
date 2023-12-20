package com.amazingbookstore.repository;

import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.amazingbookstore.model.Book;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Test
	@Sql(scripts = { "classpath:InsertInitialBookRecordForTest.sql" })
	void shouldAbleToFetchAllBooksInDB() {
		Iterable<Book> all = bookRepository.findAll();
		Long totalBookCount = StreamSupport.stream(all.spliterator(), false).count();
		Assertions.assertEquals(totalBookCount, 2);
	}

	@Test
	@Sql(scripts = { "classpath:InsertInitialBookRecordForTest.sql" })
	void shouldReturnOneBookWhenTitleisTestTitle() {
		List<Book> test_title = bookRepository.findBooksByTitle("Test");
		Assertions.assertEquals(test_title.size(), 1);
	}
}
