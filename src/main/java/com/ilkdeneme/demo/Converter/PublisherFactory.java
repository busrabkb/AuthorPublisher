package com.ilkdeneme.demo.Converter;

import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Data.Publisher;
import com.ilkdeneme.demo.Entity.AuthorEntity;
import com.ilkdeneme.demo.Entity.BookEntity;
import com.ilkdeneme.demo.Entity.PublisherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class PublisherFactory {





    public PublisherEntity createEntity(Publisher data) {
        PublisherEntity entity = new PublisherEntity();
        BookEntity bookEntity=new BookEntity();
        bookEntity.setId(Long.valueOf(data.getBook().getId()));
        bookEntity.setName(data.getBook().getName());
        bookEntity.setIsnbNo(data.getBook().getIsnbNo());
        entity.setBook(bookEntity);
        entity.setDescription(data.getDescription() );
        entity.setName(data.getName());

        return entity;
    }
    @Transactional
    public Publisher createData(Optional<PublisherEntity> entity) {
        Publisher data = new Publisher();
        Book book=new Book();
        book.setId(String.valueOf(entity.get().getBook().getId()));
        book.setName(entity.get().getBook().getName());
        book.setIsnbNo(entity.get().getBook().getIsnbNo());
        data.setBook( book);
        data.setDescription(entity.get().getDescription());
        data.setName(entity.get().getName());
        return data;
    }


}
