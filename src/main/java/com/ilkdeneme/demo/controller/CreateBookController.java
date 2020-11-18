package com.ilkdeneme.demo.controller;

import com.ilkdeneme.demo.Converter.AuthorFactory;
import com.ilkdeneme.demo.Converter.BookFactory;
import com.ilkdeneme.demo.Converter.PublisherFactory;
import com.ilkdeneme.demo.Data.AppData;
import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Data.Publisher;
import com.ilkdeneme.demo.Entity.AuthorEntity;
import com.ilkdeneme.demo.Entity.BookEntity;
import com.ilkdeneme.demo.Entity.PublisherEntity;
import com.ilkdeneme.demo.service.AuthorService;
import com.ilkdeneme.demo.service.BookService;
import com.ilkdeneme.demo.service.PublisherService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

@Component
public class CreateBookController implements Initializable {
    @FXML
    GridPane fxGrid;
    @FXML
    TextField fxName;
    @FXML
    TextField fxAuthorName;
    @FXML
    TextField fxPublisher;
    @FXML
    TextField fxIsbnNo;
    @FXML
    Button fxSaveButton;
    @FXML
    Button fxCloseButton;
    ResourceBundle rb;
    StageController stageController;

    AuthorFactory authorFactory;

    PublisherFactory publisherFactory;

    BookFactory bookFactory;

    BookService bookService;
    AuthorService authorService;
    PublisherService publisherService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.rb = resources;
        AnchorPane.setTopAnchor(fxGrid, 0.0);
        AnchorPane.setLeftAnchor(fxGrid, 0.0);
        fxGrid.setMaxSize(500, 500);
        fxGrid.setMinSize(500, 500);
        fxCloseButton.setOnMouseClicked(event ->
        {
            try {
                StageController.setOpenedBook(null);
                stageController.closeScene();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        });
        fxSaveButton.setOnMouseClicked(event ->
        {
            try {
                Book book = new Book();
                book.setName(fxName.getText());
                book.setIsnbNo(fxIsbnNo.getText());
                if (fxName.getText().equals(bookService.isBookNameExist(fxName.getText()))) {
                    stageController.loadNewScene("Menu", rb, new AppData());
                }
                Author author = new Author();
                author.setName(fxAuthorName.getText());

                Publisher publisher = new Publisher();
                publisher.setName(fxAuthorName.getText());

                Long publisherId = publisherService.savePublisher(publisher);
                publisher.setId(String.valueOf(publisherId));

                Long authorId = authorService.saveAuthor(author);
                author.setId(String.valueOf(authorId));
                book.setPublisher(publisher);
                book.setAuthor(author);
                Book savedBookData = bookService.saveBook(book);
    stageController.getBookList().put(savedBookData.getId(),savedBookData);
    StageController.setOpenedBook(null);
                stageController.closeScene();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }


    //book lar bir listede bind ile observable

    public CreateBookController(StageController stageController, AuthorFactory authorFactory, PublisherFactory publisherFactory, BookFactory bookFactory, BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.stageController = stageController;
        this.authorFactory = authorFactory;
        this.publisherFactory = publisherFactory;
        this.bookFactory = bookFactory;
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }


}
