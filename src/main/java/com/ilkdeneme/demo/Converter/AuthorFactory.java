package com.ilkdeneme.demo.Converter;


import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Data.Publisher;
import com.ilkdeneme.demo.Entity.AuthorEntity;
import com.ilkdeneme.demo.Entity.BookEntity;
import com.ilkdeneme.demo.Entity.PublisherEntity;
import com.ilkdeneme.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.aop.PublisherAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorFactory {
    public AuthorEntity createEntity(Author data) {
        AuthorEntity entity = new AuthorEntity();
entity.setId(Long.valueOf(data.getId()));
        entity.setName(data.getName());

        return entity;
    }


@Transactional
    public Author createData(Optional<AuthorEntity> entity) {
        Author data = new Author();
data.setId(String.valueOf(entity.get().getId()));
        data.setName(entity.get().getName());

        return data;
    }


}
