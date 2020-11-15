package com.ilkdeneme.demo.Data;


import com.ilkdeneme.demo.Entity.BookEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Author {
    String name;
    String surName;
    String address;
    String sex;
    String description;
    Book book=new Book();

    public Author() {

    }

    public Author(String name, Book book) {
        this.name = name;
        this.book = book;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
