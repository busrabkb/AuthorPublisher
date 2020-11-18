package com.ilkdeneme.demo.controller;

import com.ilkdeneme.demo.Converter.AuthorFactory;
import com.ilkdeneme.demo.Converter.BookFactory;
import com.ilkdeneme.demo.Converter.PublisherFactory;
import com.ilkdeneme.demo.Data.AppData;
import com.ilkdeneme.demo.Data.Author;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Data.Publisher;
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
    TextField fxSerieName;
    @FXML
    Button fxUpdateButton;
    @FXML
    Button fxCloseButton;
    @FXML
    Button fxDeleteButton;
    ResourceBundle rb;
    StageController stageController;
    BookService bookService;
    AuthorService authorService;
    PublisherService publisherService;
    Book openedBook = new Book();



    public BookDetailsController(StageController stageController, BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.stageController = stageController;
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rb = resources;
        this.openedBook = StageController.getOpenedBook();
        AnchorPane.setTopAnchor(fxGrid, 0.0);
        AnchorPane.setLeftAnchor(fxGrid, 0.0);
        fxGrid.setMaxSize(700, 700);
        fxGrid.setMinSize(700, 700);
if (!openedBook.getId().equals(null))
{    fxName.setText(openedBook.getName());
        fxAuthorName.setText(openedBook.getAuthor().getName());
        fxPublisher.setText(openedBook.getPublisher().getName());
        fxSerieName.setText(openedBook.getSeriesName());
        fxIsbnNo.setText(openedBook.getIsnbNo());}
        fxCloseButton.setOnMouseClicked(event ->
        {
            StageController.setOpenedBook(null);
            try {
                openedBook.setId(null);
                StageController.setOpenedBook(null);
                stageController.closeScene();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        });
        fxUpdateButton.setOnMouseClicked(event ->
        {
            Book updatedBook = new Book();

            updatedBook.setName(fxName.getText());
            Author author = new Author();
            author.setName(fxAuthorName.getText());
            Publisher publisher = new Publisher();
            publisher.setName(fxPublisher.getText());
            updatedBook.setSeriesName(fxSerieName.getText());
            updatedBook.setIsnbNo(fxIsbnNo.getText());
            updatedBook.setId(openedBook.getId());
             updatedBook.setAuthor(author);
          updatedBook.setPublisher(publisher);
            author.setId(openedBook.getAuthor().getId());
            authorService.update(author);
         publisher.setId( openedBook.getPublisher().getId());
            publisherService.update(publisher);
            bookService.update(updatedBook);
            //kitap listesi güncellendi
            stageController.getBookList().putIfAbsent(updatedBook.getId(),updatedBook);

        });
        fxDeleteButton.setOnMouseClicked(event ->
     {

            bookService.deleteBook(openedBook.getId());
        authorService.deleteAuthor(openedBook.getAuthor().getId());
         publisherService.deletePublisher(openedBook.getPublisher().getId());

stageController.getBookList().remove(openedBook.getId());
         openedBook.setId(String.valueOf(0));   });
    }

    private Book getBook(String newVal) {
        return stageController.getBookList().values()
                .stream().parallel()
                .filter(val -> newVal.equals(val.getName())).findFirst().get();
    }
}
