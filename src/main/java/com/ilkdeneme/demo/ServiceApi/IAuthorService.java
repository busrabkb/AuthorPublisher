package com.ilkdeneme.demo.ServiceApi;


import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Entity.AuthorEntity;
import org.springframework.stereotype.Service;

@Service
public interface IAuthorService {

 Long saveAuthor(Author data);

 void deleteAuthor(String id);
void update(Author author);
 Iterable<AuthorEntity> getAllAuthor();
// Author getAuthorfromBookId(String id);
//
// public List<Book> getAuthorBooksFromName(String name);
}
