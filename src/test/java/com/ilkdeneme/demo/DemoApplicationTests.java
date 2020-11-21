package com.ilkdeneme.demo;

import com.ilkdeneme.demo.Converter.BookFactory;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Entity.AuthorEntity;
import com.ilkdeneme.demo.Entity.BookEntity;
import com.ilkdeneme.demo.Entity.PublisherEntity;
import com.ilkdeneme.demo.Repository.BookRepository;
import com.ilkdeneme.demo.service.AuthorService;
import com.ilkdeneme.demo.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
@Autowired
	BookService bookService;
@Autowired
	AuthorService authorService;
@Autowired
	BookRepository bookRepository;
@Autowired
	BookFactory bookFactory;
Map <String,Book> bookList=new HashMap<>();
	@Test
	void contextLoads() {
	}

	@BeforeAll
	void createBook()
	{
		BookEntity book=new BookEntity();
		book.setId(Long.valueOf(1));
		book.setSeriesName("SerieName1");
		book.setIsnbNo("12314");
		book.setAuthor(new AuthorEntity(1L,"author1"));
book.setPublisher(new PublisherEntity(1L,"publisher1"));
bookService.saveBook(bookFactory.createData(book));
		bookList.put (String.valueOf(book.getId()),bookFactory.createData(book));
	}
	@Test
	void createBookTest()
	{
		Assertions.assertTrue( bookList.get("1").equals(bookRepository.findById(Long.valueOf(bookList.get("1").getId())).get())  );

	}

@Test
	void getAllBooks()
	{
		Map<String, Book> bookHashMap=bookService.getAllBook();
		

	}
}
