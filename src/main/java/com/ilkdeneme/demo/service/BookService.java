package com.ilkdeneme.demo.service;

import com.ilkdeneme.demo.Converter.BookFactory;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Entity.BookEntity;
import com.ilkdeneme.demo.Repository.AuthorRepository;
import com.ilkdeneme.demo.Repository.BookRepository;
import com.ilkdeneme.demo.Repository.PublisherRepository;
import com.ilkdeneme.demo.ServiceApi.IBookService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService  implements IBookService {
PublisherRepository publisherRepository;
AuthorRepository authorRepository;
    BookRepository bookRepository;
    BookFactory bookFactory;

    public BookService(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository, BookFactory bookFactory) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookFactory = bookFactory;

    }

    @Override
    public Book saveBook(Book data) {

 BookEntity bookEntity= bookRepository.save(bookFactory.createEntity(data));

   return  bookFactory.createData(bookEntity); }

    @Override
    public void deleteBook(int isbn) {
bookRepository.deleteByIsnbNoEquals(isbn);
    }

    @Override
    public Map<String, Book> getAllBook() {
        Map<String,Book> bookList=new HashMap<>();
  bookList.putAll(bookFactory.createBookList(bookRepository.findAll()));

             return bookList;
    }

    public Book getBookFromName(String name) {
        return  bookFactory.createData(bookRepository.findByNameEquals(name));

    }
    @Override
    public List<String> getBooksComboList() {
         return  bookFactory.createBookNameList(bookRepository.findAll());

    }

    @Override
    public boolean isBookNameExist(String name) {
       BookEntity entity= bookRepository.findByNameEquals(name);
      if (entity==null) return false;
      else
          return true;
    }
}