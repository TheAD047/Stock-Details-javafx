package com.example.assignment2gc200489790;

import com.example.assignment2gc200489790.APIUtil.APIUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Index.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        if(new Random().nextInt(0, 2) == 1) {
            stage.getIcons().add(new Image(HelloApplication.class.getResource("imgs/icon.jpg").toExternalForm()));
        }
        else {
            stage.getIcons().add(new Image(HelloApplication.class.getResource("imgs/background-image.jpg").toExternalForm()));
        }
        stage.setTitle("Stonks");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}