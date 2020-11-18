package com.ilkdeneme.demo.service;

import com.ilkdeneme.demo.Converter.PublisherFactory;
import com.ilkdeneme.demo.Data.Publisher;
import com.ilkdeneme.demo.Repository.PublisherRepository;
import com.ilkdeneme.demo.ServiceApi.IPublisherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class PublisherService implements IPublisherService {

    PublisherRepository publisherRepository;
    PublisherFactory publisherFactory;

    public PublisherService(PublisherRepository publisherRepository, PublisherFactory publisherFactory) {
        this.publisherRepository = publisherRepository;
        this.publisherFactory = publisherFactory;
    }

    @Override
    public long savePublisher(Publisher data) {
        data.setId(String.valueOf(0));
       return publisherRepository.save(publisherFactory.createEntity(data)).getId();
    }

    @Override
    public void deletePublisher(String id) {
publisherRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void update(Publisher publisher) {
  publisherRepository.save(publisherFactory.createEntity(publisher) )  ;
    }

    @Override
    public Map<String, Publisher> getAllPublisher() {
  return    publisherFactory.createPublisherList( publisherRepository.findAll()) ;
    }
@Transactional
    @Override
    public Publisher getPublisherfromId(String id) {

//      return   publisherFactory.createData( publisherRepository.findByBook_Id(Long.valueOf(id))) ;
   return  null; }
}
