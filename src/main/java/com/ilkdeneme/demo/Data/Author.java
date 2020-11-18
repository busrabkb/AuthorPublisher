package com.ilkdeneme.demo.Data;


import com.ilkdeneme.demo.Entity.BookEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Author {
   String id;
    String name;
    String surName;
    String address;
    String sex;
    String description;
    public Author() {

    }

    public Author(String name ) {
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
