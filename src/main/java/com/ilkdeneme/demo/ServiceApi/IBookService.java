package com.ilkdeneme.demo.ServiceApi;

import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IBookService {

    Book saveBook(Book data);

    void deleteBook(String isbn);


    Map<String, Book> getAllBook();
    List<String> getBooksComboList();

     boolean isBookNameExist(String name);

    Book getBookFromSerieName(String text);
    Book getBookFromIsbn(String isbn);
}
