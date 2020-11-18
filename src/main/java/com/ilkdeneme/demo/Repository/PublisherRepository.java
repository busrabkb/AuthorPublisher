package com.ilkdeneme.demo.Repository;

import com.ilkdeneme.demo.Entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends CrudRepository<PublisherEntity,Long> {
//  Optional<PublisherEntity> findByBook_Id(Long id);
}
