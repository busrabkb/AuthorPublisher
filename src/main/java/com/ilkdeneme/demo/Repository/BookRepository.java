package com.ilkdeneme.demo.Repository;

import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Entity.AuthorEntity;
import com.ilkdeneme.demo.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

public interface BookRepository  extends CrudRepository<BookEntity, Long>
{
//  @Query(value = "select m from Machine m inner join fetch m.category c inner join fetch c.categoryRoleMappings crm inner join fetch crm.userRole ur where ur.id= :roleId")
//List<Machine> machine = findByRoleId(@Param("roleId") long roleId));
//  @Query("select u.author from BookEntity u inner join u.area ar where ar.idArea = :idArea")
//@Transactional
//@Query(value = "DELETE FROM (*) WHERE pro_idx = (SELECT idx FROM problem WHERE code=?1)", nativeQuery = true)
//void deleteAllSubProblemByCodeInQuery(@Param("id") String id);
  //List<BookEntity>  findAllBooks(@Param ("author_id") long id);
  BookEntity findByIsnbNoEquals(String isbnNo);
  BookEntity deleteByIsnbNoEquals(String isbnNo);
  BookEntity deleteByIdEquals(String id);
BookEntity findByNameEquals(String name);
BookEntity findBySeriesNameEquals(String serieName);
List<BookEntity> findByAuthor(Long id);
}
