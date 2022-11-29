/**
 * Name : Arin Dhiman
 * Student no. : 200489790
 * Date : 27 November 2022
 * Description : This class controller class is used to handle the AddSymbol.fxml file
 */

package com.example.assignment2gc200489790.Controllers;

import com.example.assignment2gc200489790.APIUtil.APIUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddSymbolsController {

    @FXML
    private Button btnToAddSymbol;

    @FXML
    private Button btnToGoBackToMainMenu;

    @FXML
    private TextField fieldForSymbol;

    @FXML
    private Label span;

    /**
     * this method triggers when the user clicks the btnToAddSymbol
     * it checks if the field is empty before triggering the method add a symbol in the cache
     */
    @FXML
    void addSymbol(ActionEvent event) {
        if(fieldForSymbol.getText().isEmpty()){
            span.setText("The Field is emptyyyyyy..........");
        }
        else {
            span.setText(APIUtil.addSymbol(fieldForSymbol.getText()));
        }
    }

    /**
     * this method triggers when the user clicks the btnToGoBackToMainMenu to get back to the index.fxml
     */
    @FXML
    void gotToMainMenu(ActionEvent event) throws Exception {
        SceneController.changeScene(event, "index");
    }
}