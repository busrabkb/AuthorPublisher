package com.ilkdeneme.demo.Data;


import com.ilkdeneme.demo.Entity.BookEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Publisher {
    String name;
    String registerDate;
    String description;
    Book book=new Book();
String id;
    public Publisher(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Publisher() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
