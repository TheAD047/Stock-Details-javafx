package com.example.assignment2gc200489790.Controllers;

import com.example.assignment2gc200489790.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    /**
     * Method to change the scene and hence the stage as well
     * takes in an ActionEvent and name of the fxml file to load
     */
    public static void changeScene(ActionEvent event, String name) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(name + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        if(name.equals("index")) {
            stage.setTitle("Stomks");
        }
        else {
            stage.setTitle(name);
        }
        stage.setScene(scene);
        stage.show();
    }
}
