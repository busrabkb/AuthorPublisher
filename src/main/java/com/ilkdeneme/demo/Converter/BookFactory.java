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
public class BookFactory {


    public BookEntity createEntity(Book data) {
        BookEntity  entity= new BookEntity();
        entity.setId(Long.valueOf( data.getId()));
        entity.setName(data.getName());
        entity.setIsnbNo(data.getIsnbNo());
        entity.setSeriesName(data.getSeriesName());
        AuthorEntity authorEntity=new AuthorEntity();
        PublisherEntity publisherEntity=new PublisherEntity();
        authorEntity.setId(Long.valueOf(data.getAuthor().getId()));
        authorEntity.setName(data.getAuthor().getName());

        entity.setAuthor(authorEntity);
        publisherEntity.setName(data.getPublisher().getName());
        publisherEntity.setId(Long.valueOf(data.getPublisher().getId()));
        publisherEntity.setName(data.getPublisher().getName());
        entity.setPublisher(publisherEntity);
        return entity;
    }
@Transactional
    public Book createData(BookEntity entity) {
        Book data = new Book();
        data.setId(String.valueOf(entity.getId()));
        data.setName(entity.getName());
        data.setIsnbNo(entity.getIsnbNo());
        data.setSeriesName(entity.getSeriesName());
        Author authorData=new Author();
        Publisher publisherData=new Publisher();
        authorData.setId(String.valueOf(entity.getAuthor().getId()));
        authorData.setName(entity.getAuthor().getName());

        data.setAuthor(authorData);
        publisherData.setName(entity.getPublisher().getName());
        publisherData.setId(String.valueOf(entity.getPublisher().getId()));
        publisherData.setName(entity.getPublisher().getName());
        data.setPublisher(publisherData);
        return data;
    }

    public BookFactory() {
    }
@Transactional
    public Map<String, Book> createBookList(Iterable<BookEntity> all) {
        Map<String, Book> books = new HashMap<>();
        all.forEach(bookEntity ->
                {
                    Book book = createData(bookEntity);
                    books.put(book.getId(), book);
                }

        );
        return books;
    }
@Transactional
    public List<String> createBookNameList(Iterable<BookEntity> all) {
        List<String> books = new ArrayList<>();
        all.forEach(bookEntity ->
                {

                    books.add(bookEntity.getName());
                }

        );
        return books;
    }
@Transactional
    public List<Book> createBookDataList(Iterable<BookEntity> all) {
        List<Book> books = new ArrayList<>();
        all.forEach(bookEntity ->
                {
                    Book book = new Book();
                    book.setIsnbNo(bookEntity.getIsnbNo());
                    //book.setAuthor(new Author(bookEntity.getAuthor().getName()  ));

                    books.add(book);
                }

        );
        return books;
    }


}
