package com.ilkdeneme.demo.service;

import com.ilkdeneme.demo.Converter.AuthorFactory;
import com.ilkdeneme.demo.Converter.BookFactory;
import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Entity.AuthorEntity;
import com.ilkdeneme.demo.Repository.AuthorRepository;
import com.ilkdeneme.demo.ServiceApi.IAuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AuthorService implements IAuthorService {

AuthorFactory authorFactory;
AuthorRepository authorRepository;


    public AuthorService(AuthorFactory authorFactory, AuthorRepository authorRepository) {
        this.authorFactory = authorFactory;
        this.authorRepository = authorRepository;

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
}
