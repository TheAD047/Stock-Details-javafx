package com.example.assignment2gc200489790.Controllers;

import com.example.assignment2gc200489790.APIUtil.APIUtil;
import com.example.assignment2gc200489790.Controllers.SceneController;
import com.example.assignment2gc200489790.Models.APIResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddSymbolsController implements Initializable {

    @FXML
    private Button btnToAddSymbol;

    @FXML
    private Button btnToGoBackToMainMenu;

    @FXML
    private TextField fieldForSymbol;

    @FXML
    private Label span;

    @FXML
    void addSymbol(ActionEvent event) {
        if(fieldForSymbol.getText().isEmpty()){
            span.setText("The Field is emptyyyyyy..........");
        }
        else {
            span.setText(APIUtil.addSymbol(fieldForSymbol.getText()));
        }
    }

    @FXML
    void gotToMainMenu(ActionEvent event) throws Exception {
        SceneController.changeScene(event, "index");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}