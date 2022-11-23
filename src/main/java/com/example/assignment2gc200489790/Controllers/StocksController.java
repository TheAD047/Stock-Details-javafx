package com.example.assignment2gc200489790.Controllers;

import com.example.assignment2gc200489790.APIUtil.APIUtil;
import com.example.assignment2gc200489790.Models.StockDetail;
import com.example.assignment2gc200489790.Symbol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class StocksController implements Initializable {


    @FXML
    private LineChart<String, Double> lineChart;

    @FXML
    private Button btnForMainMenu;

    @FXML
    private Label labelForTitle;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;


    @FXML
    void backToMainMenu(ActionEvent event) throws Exception{
        SceneController.changeScene(event, "Index");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelForTitle.setText("Stock Info for " + Symbol.getSymbol());

        Map<String, StockDetail> map = APIUtil.getStocks(Symbol.getSymbol());

        XYChart.Series<String, Double> open = new XYChart.Series<>();
        open.setName("Open");
        XYChart.Series<String, Double> high = new XYChart.Series<>();
        high.setName("High");
        XYChart.Series<String, Double> low = new XYChart.Series<>();
        low.setName("Low");
        XYChart.Series<String, Double> close = new XYChart.Series<>();
        close.setName("Close");
        XYChart.Series<String, Double> volume = new XYChart.Series<>();
        volume.setName("Volume");

        map.keySet().forEach(key -> {
            //volume.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getVolume()) / 10));
            open.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getOpen())));
            high.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getHigh())));
            low.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getLow())));
            close.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getClose())));

        });

        lineChart.getData().addAll(open, high, low, close);
    }
}
