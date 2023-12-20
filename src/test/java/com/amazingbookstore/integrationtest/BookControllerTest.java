package com.amazingbookstore.integrationtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import com.amazingbookstore.AmazingBookStoreBackendApplication;
import com.amazingbookstore.dto.BookDto;

@SpringBootTest(classes = AmazingBookStoreBackendApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	@Sql(scripts = { "classpath:InsertInitialBookRecordForTest.sql" })
	void shouldReturnBooksWhenBookApiCalled() {
		BookDto[] listOfBooks = testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/books",
				BookDto[].class);
		assertThat(listOfBooks).isNotNull();
		assertThat(listOfBooks.length).isEqualTo(2);
	}

}
