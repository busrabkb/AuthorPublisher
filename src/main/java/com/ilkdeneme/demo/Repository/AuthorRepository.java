package com.ilkdeneme.demo.Repository;

import com.ilkdeneme.demo.Entity.AuthorEntity;
import com.ilkdeneme.demo.Entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
Optional<AuthorEntity> findByBook_Id(Long id);
     @Query("Select book from AuthorEntity author join BookEntity book on book.id=author.book.id where :name=author.name ")
  // @Query("Select author.book.id from AuthorEntity author  where author.name=name")
    List<BookEntity> getBooks(@Param("name") String name);
}
