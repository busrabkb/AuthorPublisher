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
        entity.setId(Long.valueOf(data.getId()));
           entity.setDescription(data.getDescription() );
        entity.setName(data.getName());

        return entity;
    }
    @Transactional
    public Publisher createData(Optional<PublisherEntity> entity) {
        Publisher data = new Publisher();
       data.setId(String.valueOf(entity.get().getId()));
        data.setDescription(entity.get().getDescription());
        data.setName(entity.get().getName());
        return data;
    }
    public Map<String, Publisher> createPublisherList(Iterable<PublisherEntity> all) {
        Map<String, Publisher> publisherMap = new HashMap<>();
        all.forEach(entity ->
                {
                    Publisher publisher = createData(Optional.ofNullable(entity));
                    publisherMap.put(String.valueOf(entity.getId()), publisher);
                }

        );
        return publisherMap;
    }

}
