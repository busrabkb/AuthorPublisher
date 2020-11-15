package com.ilkdeneme.demo.Data;

public class AppData {
 public  Book book;


    public AppData() {
    }

    public AppData(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
