package com.ilkdeneme.demo.service;

import com.ilkdeneme.demo.Converter.AuthorFactory;
import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Repository.AuthorRepository;
import com.ilkdeneme.demo.ServiceApi.IAuthorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
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
    public Long saveAuthor(Author  data) {
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
    public List<Author> getAllAuthor() {

  //return authorFactory. authorRepository.findAll();
return null;
    }

//    @Transactional
//    public List<Book> getAuthorBooksFromName(String name)
//    {
//        List<Book> bookDataList=new ArrayList<>();
//     List<BookEntity> bookEntityList=  authorRepository.getBooks(name);
//bookEntityList.forEach(bookEntity ->
//        {
//        Book book= new Book();
//        book.setId(String.valueOf(bookEntity.getId()));
//        book.setName(bookEntity.getName());
//        book.setIsnbNo(bookEntity.getIsnbNo());
//        book.setSeriesName(bookEntity.getSeriesName());
//        bookDataList.add(book);
//        }
//);


//        return bookDataList;

//
//    }
}
