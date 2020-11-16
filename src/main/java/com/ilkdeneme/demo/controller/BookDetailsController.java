package com.ilkdeneme.demo.controller;

import com.ilkdeneme.demo.Converter.AuthorFactory;
import com.ilkdeneme.demo.Converter.BookFactory;
import com.ilkdeneme.demo.Converter.PublisherFactory;
import com.ilkdeneme.demo.Data.AppData;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.MenuController;
import com.ilkdeneme.demo.service.AuthorService;
import com.ilkdeneme.demo.service.BookService;
import com.ilkdeneme.demo.service.PublisherService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
@Qualifier("bookDetails")
@Component
public class BookDetailsController implements Initializable {
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
    Button fxCloseButton;
    ResourceBundle rb;
    StageController stageController;



    BookService bookService;
    AuthorService authorService;
    PublisherService publisherService;
    Book openedBook=new Book();
    public void setData(AppData data) {

        this.openedBook = stageController.bookList.get(data.getBook().getId());


    }

    public BookDetailsController(StageController stageController, BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.stageController = stageController;
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rb=resources;
        this.openedBook = StageController.getOpenedBook();
        AnchorPane.setTopAnchor(fxGrid,0.0);
        AnchorPane.setLeftAnchor(fxGrid,0.0);
        fxGrid.setMaxSize(700, 700);
        fxGrid.setMinSize(700, 700);

        fxName.setText(openedBook.getName());
        fxAuthorName.setText( authorService.getAuthorfromId(openedBook.getId()).getName() );
        fxPublisher.setText(publisherService.getPublisherfromId(openedBook.getId()).getName());
        fxIsbnNo.setText(openedBook.getIsnbNo());
        fxCloseButton.setOnMouseClicked(event ->
        { StageController.setOpenedBook(null);
            try {
                stageController.  closeScene();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        });
    }

}
