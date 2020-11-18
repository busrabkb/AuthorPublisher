package com.ilkdeneme.demo.Data;

import java.util.ArrayList;
import java.util.List;

public class AppData {
 public  Book book;
 public boolean isUpdate;
    List<Book> searchedAuthorBooksList=new ArrayList<>();

    public AppData() {
    }

    public AppData(Book book) {
        this.book = book;
    }

    public AppData(List<Book> searchedAuthorBooksList) {
        this.searchedAuthorBooksList = searchedAuthorBooksList;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getSearchedAuthorBooksList() {
        return searchedAuthorBooksList;
    }

    public void setSearchedAuthorBooksList(List<Book> searchedAuthorBooksList) {
        this.searchedAuthorBooksList = searchedAuthorBooksList;
    }
}
