package com.ilkdeneme.demo;

import com.ilkdeneme.demo.Controller.StageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.InputStreamReader;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
@SpringBootApplication(scanBasePackages={"com.ilkdeneme.demo"})

public class DemoApplication extends Application  {
ResourceBundle rb;
    private ApplicationContext springContext;
@Qualifier("stageController")
    StageController stageController;

	public static void main(String[] args) {
     launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        springContext = SpringApplication.run(DemoApplication.class);
  stageController= (StageController) springContext.getBean(StageController.class);
	}

    @Override
    public void start(Stage stage)  {
  try{
 FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(springContext::getBean);
rb=new PropertyResourceBundle(new InputStreamReader(  ClassLoader.getSystemClassLoader().getResourceAsStream("Label_tr_TR.properties"
)));

       loader.setResources(rb);
        loader.setLocation( getClass().getClassLoader().getResource("Menu.fxml").toURI().toURL());
        AnchorPane root = loader.load();
      root.setMaxSize(700, 700);
      root.setMinSize(700,700);
      stage=new Stage();
      stage.setScene(new Scene(root));
        stageController.setMainStage(stage);


        stage .show();
    }
  catch (Exception e)
  {
      System.out.println(e);
  }

        }

}
