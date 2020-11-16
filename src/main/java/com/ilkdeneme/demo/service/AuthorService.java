package com.ilkdeneme.demo.service;

import com.ilkdeneme.demo.Converter.AuthorFactory;
import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Entity.BookEntity;
import com.ilkdeneme.demo.Repository.AuthorRepository;
import com.ilkdeneme.demo.ServiceApi.IAuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {

AuthorFactory authorFactory;
AuthorRepository authorRepository;
EntityManager manager;

    public AuthorService(AuthorFactory authorFactory, AuthorRepository authorRepository, EntityManager manager) {
        this.authorFactory = authorFactory;
        this.authorRepository = authorRepository;
        this.manager=manager;
    }

    @Override
    public void saveAuthor(Author  data) {
  authorRepository.save(authorFactory.createEntity(data)
      );
    }

    @Override
    public void deleteAuthor(Author data) {

    }

    @Override
    public List<Author> getAllAuthor() {
//        authorFactory.c
 //return authorRepository.findAll();
   return null;
    }
@Transactional
    @Override
    public Author getAuthorfromId(String id) {

        return  authorFactory.createData( authorRepository.findByBook_Id(Long.valueOf(id)));
    }
    @Transactional
    public List<Book> getAuthorBooksFromName(String name)
    {
        List<Book> bookDataList=new ArrayList<>();
     List<BookEntity> bookEntityList=  authorRepository.getBooks(name);
bookEntityList.forEach(bookEntity ->
        {
        Book book= new Book();
        book.setId(String.valueOf(bookEntity.getId()));
        book.setName(bookEntity.getName());
        book.setIsnbNo(bookEntity.getIsnbNo());
        book.setSeriesName(bookEntity.getSeriesName());
        bookDataList.add(book);
        }
);


        return bookDataList;
    }
}
