package com.ilkdeneme.demo.ServiceApi;


import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Data.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAuthorService {

 void saveAuthor(Author data);

 void deleteAuthor(Author data);

 List<Author> getAllAuthor();
 Author getAuthorfromId(String id);
 public List<Book> getAuthorBooksFromName(String name);
}
