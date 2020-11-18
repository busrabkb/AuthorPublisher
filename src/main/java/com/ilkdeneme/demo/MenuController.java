package com.ilkdeneme.demo;

import com.ilkdeneme.demo.Data.AppData;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.Controller.StageController;
import com.ilkdeneme.demo.service.AuthorService;
import com.ilkdeneme.demo.service.BookService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Component
public class MenuController implements Initializable {
    @FXML
    ComboBox fxBookList;
    @FXML
    Button fxSearchBookNameButton;
    @FXML
    Button fxSearchSerieNameButton;
    @FXML
    Button fxSearchAuthorNameButton;
    @FXML
    TextField fxSearchBookName;
    @FXML
    TextField fxSearchSerieName;
    @FXML
    TextField fxSearchAuthorName;
    ResourceBundle rb;
    @FXML
    TextField fxSearchIsbn;
    @FXML
    Button fxSearchIsbnButton;
    @FXML
    GridPane fxMenuGrid;
    @FXML
    AnchorPane fxAnchor;
    StageController stageController;
    BookService bookService;
    AuthorService authorService;
    @FXML
    Button fxCreateBookButton;

    public MenuController(StageController stageController, BookService bookService, AuthorService authorService) {
        this.stageController = stageController;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageController.getBookList().putAll(bookService.getAllBook());
        fxBookList.getItems().addAll(bookService.getBooksComboList());
        AnchorPane.setTopAnchor(fxMenuGrid, 0.0);
        AnchorPane.setLeftAnchor(fxMenuGrid, 0.0);

        fxMenuGrid.setMaxSize(700, 700);
        fxMenuGrid.setMinSize(700, 700);
        this.rb = resources;
        fxBookList.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newBookName) -> {
            try {//book name uqique olduğu için bu name ile listeden arar. Bulunca diğer sayfaya gönderir
                //static old için direkt static liste de cağrılabilir
                String newVal = (String) newBookName;
                StageController.setOpenedBook(stageController.getBookList().values()
                .stream().filter(book -> book.getName().equals(newVal)).findFirst().get());
                stageController.loadNewScene
                        ("BookDetails", rb, new AppData(
                                stageController.getBookList().get(newVal)
                        ));

            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        fxSearchBookNameButton.setOnMouseClicked(event ->
        {
            try {
                Book book = bookService.getBookFromName(fxSearchBookName.getText());
                StageController.setOpenedBook(book);
                stageController.loadNewScene("BookDetails", rb, new AppData(book));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        });
        fxSearchIsbnButton.setOnMouseClicked(event ->
        {
            try {
                Book book = bookService.getBookFromIsbn(fxSearchIsbn.getText());
                StageController.setOpenedBook(book);
                stageController.loadNewScene("BookDetails", rb, new AppData(book));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        });
        fxSearchAuthorNameButton.setOnMouseClicked(event ->
        {
            if (bookService.getBookAuthorFromAuthorId(fxSearchAuthorName.getText()).size() != 0) {
                stageController.setSearchedAuthorBooksList(
                       getAuthorBooksFromBookList(fxSearchAuthorName.getText())
                     );
                stageController.openBooksScene("searchedAuthorBookDetails", new AppData(StageController.getSearchedAuthorBooksList()));
            }
        });
        fxSearchSerieNameButton.setOnMouseClicked(event ->
        {
            try {
                if (bookService.getBookFromSerieName(fxSearchSerieName.getText()) != null) {
                    StageController.setOpenedBook(bookService.getBookFromSerieName(fxSearchSerieName.getText()));
                    stageController.loadNewScene("BookDetails", rb, new AppData());

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });



        fxCreateBookButton.setOnMouseClicked(event ->
        {
            try {
                stageController.loadNewScene("createBook", rb, new AppData());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

        });

    }

    private List<Book> getAuthorBooksFromBookList(String authorName) {
        return  stageController.getBookList().values()
                .stream().parallel()
                .filter(val -> val.getAuthor().getName().equals(authorName)).collect(Collectors.toList()) ;
    }



}
