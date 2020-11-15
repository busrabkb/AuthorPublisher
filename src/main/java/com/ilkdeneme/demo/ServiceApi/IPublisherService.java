package com.ilkdeneme.demo.ServiceApi;

import com.ilkdeneme.demo.Data.Publisher;
import org.springframework.stereotype.Service;

@Service
public interface IPublisherService {

   void savePublisher(Publisher data);

   void deletePublisher(Publisher data);

   void getAllPublisher();

    Publisher getPublisherfromId(String id);
}
