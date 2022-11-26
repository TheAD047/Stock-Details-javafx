package com.example.assignment2gc200489790.Controllers;

import com.example.assignment2gc200489790.APIUtil.APIUtil;
import com.example.assignment2gc200489790.Models.Symbol;
import com.example.assignment2gc200489790.Setting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.*;

public class IndexController implements Initializable {

    @FXML
    private Button btnForStocks;

    @FXML
    private ComboBox<Symbol> comboBoxForSymbols;

    @FXML
    private Label labelForMsg;

    @FXML
    void seeStocksForSymbol(ActionEvent event) throws Exception{
        if(comboBoxForSymbols.getValue() == null) {
            labelForMsg.setText("Please Select A Company...");
        }
        else {
            Setting.setSymbol(comboBoxForSymbols.getValue().toString());
            SceneController.changeScene(event, "stocks");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Symbol[] symbols = APIUtil.getSymbolsForComboBox();

        comboBoxForSymbols.getItems().addAll(symbols);
    }
}