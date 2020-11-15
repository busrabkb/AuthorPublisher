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

        entity.setName(data.getName());
        BookEntity bookEntity = new BookEntity();

bookEntity.setName(data.getBook().getName());
bookEntity.setId(Long.valueOf(data.getBook().getId()));
        bookEntity.setIsnbNo(data.getBook().getIsnbNo());
        entity.setDescription(data.getDescription());
entity.setBook( bookEntity);

        return entity;
    }


@Transactional
    public Author createData(Optional<AuthorEntity> entity) {
        Author data = new Author();
        Book book=new Book();
        book.setIsnbNo(entity.get().getBook().getIsnbNo());
        book.setName(entity.get().getBook().getName());
        book.setId(String.valueOf(entity.get().getBook().getId()));
         data.setBook(book);
        data.setName(entity.get().getName());
        return data;
    }


}
