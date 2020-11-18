package com.ilkdeneme.demo.ServiceApi;

import com.ilkdeneme.demo.Data.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IBookService {

    Book saveBook(Book data);

    void deleteBook(String isbn);


    Map<String, Book> getAllBook();
    List<String> getBooksComboList();
      Book getBookFromName(String name);
    boolean isBookNameExist(String name);
      void update(Book name);
    Book getBookFromSerieName(String text);
    Book getBookFromIsbn(String isbn);

    List<Book> getBookAuthorFromAuthorId(String id);
}
