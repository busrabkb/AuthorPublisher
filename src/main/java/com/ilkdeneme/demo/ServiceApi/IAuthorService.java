package com.ilkdeneme.demo.ServiceApi;


import com.ilkdeneme.demo.Data.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAuthorService {

 Long saveAuthor(Author data);

 void deleteAuthor(String id);
void update(Author author);
 List<Author> getAllAuthor();
// Author getAuthorfromBookId(String id);
//
// public List<Book> getAuthorBooksFromName(String name);
}
