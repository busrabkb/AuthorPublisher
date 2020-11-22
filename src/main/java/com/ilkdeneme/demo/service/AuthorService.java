package com.ilkdeneme.demo.service;

import com.ilkdeneme.demo.Converter.AuthorFactory;
import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Entity.AuthorEntity;
import com.ilkdeneme.demo.Repository.AuthorRepository;
import com.ilkdeneme.demo.ServiceApi.IAuthorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {

    AuthorFactory authorFactory;
    AuthorRepository authorRepository;
    EntityManager manager;

    public AuthorService(AuthorFactory authorFactory, AuthorRepository authorRepository, EntityManager manager) {
        this.authorFactory = authorFactory;
        this.authorRepository = authorRepository;
        this.manager = manager;
    }

    @Override
    public Long saveAuthor(Author data) {
        data.setId(String.valueOf(0));
        return authorRepository.save(authorFactory.createEntity(data)).getId();

    }

    @Override
    public void deleteAuthor(String id) {
        authorRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void update(Author author) {
        authorRepository.save(authorFactory.createEntity(author));
    }

    @Override
    public Iterable<AuthorEntity> getAllAuthor() {
       Iterable<AuthorEntity> entityList= authorRepository.findAll();
        return  entityList;
    }

    public Author findById(String id)
    {
       Optional<AuthorEntity> entity= authorRepository.findById(Long.valueOf(id)) ;
   if (entity!=null)
       return authorFactory.createData(entity);
   return null;
    }
}
