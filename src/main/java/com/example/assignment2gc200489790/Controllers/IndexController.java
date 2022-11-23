package com.example.assignment2gc200489790.Controllers;

import com.example.assignment2gc200489790.Symbol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    @FXML
    private Button btnForStocks;

    @FXML
    private ComboBox<String> comboBoxForSymbols;

    @FXML
    private Label labelForMsg;

    @FXML
    void seeStocksForSymbol(ActionEvent event) throws Exception{
        if(comboBoxForSymbols.getValue() == null) {
            labelForMsg.setText("Please Select A Company...");
        }
        else {
            Symbol.setSymbol(comboBoxForSymbols.getValue());
            SceneController.changeScene(event, "stocks");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxForSymbols.getItems().addAll("IBM", "Dell");
    }
}