package com.ilkdeneme.demo.controller;

import com.ilkdeneme.demo.Data.AppData;
import com.ilkdeneme.demo.Data.Book;
import com.ilkdeneme.demo.service.AuthorService;
import com.ilkdeneme.demo.service.BookService;
import com.ilkdeneme.demo.service.PublisherService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

@Component("stageController")
public class StageController {
    public Stage mainStage;
public static Book openedBook=new Book();
    BookService bookService;
    AuthorService authorService;
    PublisherService publisherService;
    public HashMap<String, Book> bookList = new HashMap<>();
    @Autowired
    private ApplicationContext appContext;


    public void loadNewScene(String sceneName, ResourceBundle rb, AppData data) throws IOException, URISyntaxException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(appContext::getBean);

            loader.setResources(rb);
            loader.setLocation(getClass().getClassLoader().getResource(sceneName + ".fxml").toURI().toURL());
            AnchorPane root = (AnchorPane) loader.load();
          setOpenedBook(data.getBook());
//            if (loader.getController().getClass().equals(BookDetailsController.class))
//    setDataToControllerReflection(loader,data);
            root.setPrefSize(500, 500);
            getMainStage().setScene(new Scene(root));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void setDataToControllerReflection(FXMLLoader loader,AppData data) throws IOException {
        //reflection kullanarak controller a data göndermek
        //her constructor aynı parametreleri almadığı için setData metoduna erişimi bu şekilde sağlayarak geçiş sağlanabilir
        try {     Class[] cArg = new Class[4]; //Our constructor has 3 arguments
        cArg[0] = StageController.class; //First argument is of *object* type Long
        cArg[1] = BookService.class; //Second argument is of *object* type String
        cArg[2] = AuthorService.class; //Third argument is of *primitive* type int
        cArg[3]=PublisherService.class;
            AnchorPane root = (AnchorPane) loader.load();
            loader.getController().getClass().getMethod("setData", AppData.class).invoke(loader.getController().getClass().getDeclaredConstructor(
                    cArg     ).newInstance(this
                    , bookService, authorService, publisherService), data);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Book getOpenedBook() {
        return openedBook;
    }

    public static void setOpenedBook(Book openedBook) {
        StageController.openedBook = openedBook;
    }

    public StageController() {
    }
//public Stage openPopup()
//{
//    final Stage dialog = new Stage();
//    dialog.initModality(Modality.APPLICATION_MODAL);
//    dialog.initOwner(getMainStage());
//    VBox dialogVbox = new VBox(20);
//    dialogVbox.getChildren().add(new Text("This is a Dialog"));
//    Scene dialogScene = new Scene(dialogVbox, 300, 200);
//    dialog.setScene(dialogScene);
//return dialog;}

    public HashMap<String, Book> getBookList() {
        return bookList;
    }

    public void setBookList(HashMap<String, Book> bookList) {
        this.bookList = bookList;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public Stage getMainStage() {
        return mainStage;
    }
}
