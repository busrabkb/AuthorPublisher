package com.ilkdeneme.demo.Repository;

import com.ilkdeneme.demo.Entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
Optional<AuthorEntity> findByBook_Id(Long id);
}
