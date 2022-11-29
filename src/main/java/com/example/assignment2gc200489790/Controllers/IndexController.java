/**
 * Name : Arin Dhiman
 * Student no. : 200489790
 * Date : 27 November 2022
 * Description : This class controller class is used to handle the index.fxml file
 */

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
    private Button btnToAddSymbol;

    @FXML
    private ComboBox<Symbol> comboBoxForSymbols;

    @FXML
    private Label labelForMsg;

    /**
     * This method triggers when btnForStocks is clicked
     * It checks if the combobox is empty or not to decide whether to load the stock details
     * or display a message to the user
     */
    @FXML
    void seeStocksForSymbol(ActionEvent event) throws Exception{
        if(comboBoxForSymbols.getValue() == null) {
            labelForMsg.setText("Please Select A Company...");
        }
        else {
            //read the value from the combobox and set the Settings.symbol parameter to this value
            Setting.setSymbol(comboBoxForSymbols.getValue().toString());
            SceneController.changeScene(event, "stocks");
        }
    }

    /**
     * overriding the initialize method
     * populates the combobox from the symbols.json file
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Symbol[] symbols = APIUtil.getSymbolsForComboBox();

        comboBoxForSymbols.getItems().addAll(symbols);
    }

    /**
     * this method is triggered when btnToAddSymbol is clicked
     * it loads the AddSymbol.fxml file
     */
    @FXML
    void goToAddSymbol(ActionEvent event) throws Exception {
        SceneController.changeScene(event,"AddSymbol");
    }
}