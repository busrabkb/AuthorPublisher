package com.ilkdeneme.demo.ServiceApi;

import com.ilkdeneme.demo.Data.Publisher;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface IPublisherService {

   long savePublisher(Publisher data);

    void deletePublisher(String id);

    void update (Publisher publisher);
    public Map<String, Publisher> getAllPublisher();
    Publisher getPublisherfromId(String id);
}
