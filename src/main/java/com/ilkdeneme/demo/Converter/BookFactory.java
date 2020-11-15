package com.ilkdeneme.demo.Converter;

import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Data.Publisher;
import com.ilkdeneme.demo.Entity.AuthorEntity;
import com.ilkdeneme.demo.Entity.BookEntity;
import com.ilkdeneme.demo.Entity.PublisherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookFactory {

    AuthorFactory authorFactory;


    public BookEntity createEntity(Book data) {
        BookEntity entity = new BookEntity();
 entity.setId(Long.valueOf(data.getId()));
entity.setName(data.getName());
        entity.setIsnbNo(data.getIsnbNo());

        return entity;
    }
public Book createData(BookEntity entity) {
        Book data = new Book();
    data.setId(String.valueOf(entity.getId()));
   data.setName(entity.getName());
         data.setIsnbNo(entity.getIsnbNo());
         return data;
    }

    public BookFactory(AuthorFactory authorFactory ) {
        this.authorFactory = authorFactory;
       }

    public  Map<String,Book>  createBookList(Iterable<BookEntity> all) {
        Map<String,Book> books=new HashMap<>();
        all.forEach(bookEntity ->
                {
        Book book=    createData(bookEntity);
                  books.put(book.getId(),book);
                }

        );
        return books;
    }
    public         List<String >  createBookNameList(Iterable<BookEntity> all) {
        List<String > books=new ArrayList<>();
        all.forEach(bookEntity ->
                {

                    books.add(bookEntity.getName());
                }

        );
        return books;
    }
    public List<Book> createBookDataList(Iterable<BookEntity> all) {
        List<Book> books=new ArrayList<>();
        all.forEach(bookEntity ->
                {
                    Book book=new Book();
                    book.setIsnbNo(bookEntity.getIsnbNo());
                     //book.setAuthor(new Author(bookEntity.getAuthor().getName()  ));

                    books.add(book);
                }

        );
        return books;
    }

    public List<BookEntity> createBookEntityList(List<Book> books) {
        List<BookEntity> bookEntityList=new ArrayList<>();
books.forEach(book -> {
    BookEntity bookEntity=new BookEntity();
   //  bookEntity.setAuthor(new AuthorEntity(book.getAuthor().getName()  ));
    bookEntity.setIsnbNo(book.getIsnbNo());
    bookEntity.setName(book.getName());
    bookEntityList.add(bookEntity);
});
return  bookEntityList;
    }
}
