package com.ilkdeneme.demo.Repository;

import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

public interface BookRepository  extends CrudRepository<BookEntity, Long>
{ BookEntity findByIsnbNoEquals(int isbnNo);
  BookEntity deleteByIsnbNoEquals(int isbnNo);
BookEntity findByNameEquals(String name);
}
