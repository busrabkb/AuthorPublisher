package com.ilkdeneme.demo.Entity;

import org.hibernate.mapping.UniqueKey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique=true)
    String name;
    String subName;
    String seriesName;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id", nullable = false)
    PublisherEntity publisher=new PublisherEntity();

    @ManyToOne( optional = false, cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    AuthorEntity author=new AuthorEntity();
    @Column()
    String isnbNo;
    String description;


    public BookEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookEntity() {
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }


    public String getIsnbNo() {
        return isnbNo;
    }

    public void setIsnbNo(String isnbNo) {
        this.isnbNo = isnbNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
