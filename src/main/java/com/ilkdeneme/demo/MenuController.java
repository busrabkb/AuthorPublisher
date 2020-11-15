package com.ilkdeneme.demo;

import com.ilkdeneme.demo.Data.AppData;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.controller.StageController;
import com.ilkdeneme.demo.service.BookService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

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
    ResourceBundle rb;
    @FXML
    Button fxUpdateButton;
    @FXML
    Button fxDeleteButton;
    @FXML
    GridPane fxMenuGrid;
    @FXML
    AnchorPane fxAnchor;
    StageController stageController;
    BookService bookService;
    @FXML
    Button fxCreateBookButton;

    public MenuController(StageController stageController, BookService bookService) {
        this.stageController = stageController;
        this.bookService = bookService;


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageController.getBookList().putAll(bookService.getAllBook());
        fxBookList.getItems().addAll(bookService.getBooksComboList());
        AnchorPane.setTopAnchor(fxMenuGrid, 0.0);
        AnchorPane.setLeftAnchor(fxMenuGrid, 0.0);
        fxMenuGrid.setMaxSize(500, 500);
        fxMenuGrid.setMinSize(500, 500);
        this.rb = resources;
        fxBookList.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newBookName) -> {
            try {//book name uqique olduğu için bu name ile listeden arar. Bulunca diğer sayfaya gönderir
                //static old için direkt static liste de cağrılabilir
                String newVal = (String) newBookName;
                StageController.setOpenedBook(getBook(newVal));
                stageController.loadNewScene
                        ("BookDetails", rb, new AppData(
                           getBook(newVal)
                        ));

            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
        fxSearchBookNameButton.setOnMouseClicked(event ->
        {


        });
        fxSearchAuthorNameButton.setOnMouseClicked(event ->
        {


        });
        fxUpdateButton.setOnMouseClicked(event ->
        {

        });
        fxDeleteButton.setOnMouseClicked(event ->
        {


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

    private Book getBook (String newVal) {
        return stageController.getBookList().values()
                .stream().parallel()
                .filter(val -> newVal.equals(val.getName())).findFirst().get();
    }

    private void openBookDetails(String path) throws IOException {
        try {
            stageController.loadNewScene("BookDetails", rb, new AppData());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
