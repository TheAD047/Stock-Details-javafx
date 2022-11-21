package com.example.assignment2gc200489790.Controllers;

import com.example.assignment2gc200489790.APIUtil.APIUtil;
import com.example.assignment2gc200489790.Symbol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class StocksController implements Initializable {

    @FXML
    private Button btnForMainMenu;

    @FXML
    private Label labelForTitle;

    @FXML
    void backToMainMenu(ActionEvent event) throws Exception{
        SceneController.changeScene(event, "Index");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelForTitle.setText("Stock Info for " + Symbol.getSymbol());
        APIUtil.getStocks(Symbol.getSymbol());
    }
}
