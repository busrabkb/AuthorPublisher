package com.ilkdeneme.demo.service;

import com.ilkdeneme.demo.Converter.PublisherFactory;
import com.ilkdeneme.demo.Data.Publisher;
import com.ilkdeneme.demo.Entity.PublisherEntity;
import com.ilkdeneme.demo.Repository.PublisherRepository;
import com.ilkdeneme.demo.ServiceApi.IPublisherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PublisherService implements IPublisherService {

    PublisherRepository publisherRepository;
    PublisherFactory publisherFactory;

    public PublisherService(PublisherRepository publisherRepository, PublisherFactory publisherFactory) {
        this.publisherRepository = publisherRepository;
        this.publisherFactory = publisherFactory;
    }

    @Override
    public void savePublisher(Publisher data) {
        PublisherEntity publisherEntity= publisherRepository.save(publisherFactory.createEntity(data));
    }

    @Override
    public void deletePublisher(Publisher data) {

    }

    @Override
    public void getAllPublisher() {

    }
@Transactional
    @Override
    public Publisher getPublisherfromId(String id) {

      return   publisherFactory.createData( publisherRepository.findByBook_Id(Long.valueOf(id))) ;
    }
}
