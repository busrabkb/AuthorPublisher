package com.ilkdeneme.demo.ServiceApi;

import com.ilkdeneme.demo.Data.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IBookService {

    Book saveBook(Book data);

    void deleteBook(int isbn);

    Map<String, Book> getAllBook();
    List<String> getBooksComboList();

     boolean isBookNameExist(String name);
}
