package com.ilkdeneme.demo.Data;


import com.ilkdeneme.demo.Entity.BookEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Publisher {
    String id;
    String name;
    String registerDate;
    String description;

    public Publisher(String name ) {
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Publisher() {
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
