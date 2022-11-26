package com.example.assignment2gc200489790.Controllers;

import com.example.assignment2gc200489790.APIUtil.APIUtil;
import com.example.assignment2gc200489790.Models.StockDetail;
import com.example.assignment2gc200489790.Models.Symbol;
import com.example.assignment2gc200489790.Setting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class StocksController implements Initializable {
    private XYChart.Series<String, Double> open = new XYChart.Series<>();
    private XYChart.Series<String, Double> high = new XYChart.Series<>();
    private XYChart.Series<String, Double> low = new XYChart.Series<>();
    private XYChart.Series<String, Double> close = new XYChart.Series<>();
    private XYChart.Series<String, Double> volume = new XYChart.Series<>();

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
    private ComboBox<String> comboBoxForCategory;


    @FXML
    void backToMainMenu(ActionEvent event) throws Exception{
        SceneController.changeScene(event, "Index");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelForTitle.setText("Stock Info for " + Setting.getSymbol());

        comboBoxForCategory.getItems().addAll("Open", "High", "Low", "Close", "Volume");

        comboBoxForCategory.setValue("Open");
        updateChart(new ActionEvent());

        Map<String, StockDetail> map = APIUtil.getStocks(Setting.getSymbol());

        open.setName("Open");
        high.setName("High");
        low.setName("Low");
        close.setName("Close");
        volume.setName("Volume");

        map.keySet().forEach(key -> {
            volume.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getVolume()) / 10));
            open.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getOpen())));
            high.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getHigh())));
            low.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getLow())));
            close.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getClose())));

        });
    }

    @FXML
    void updateChart(ActionEvent event) {
        String value = comboBoxForCategory.getValue();

        lineChart.getData().remove(0, lineChart.getData().size());

        if(value.equals("Open")) {
            lineChart.getData().add(open);
        }
        else if(value.equals("High")) {
            lineChart.getData().add(high);
        }
        else if(value.equals("Low")) {
            lineChart.getData().add(low);
        }
        else if(value.equals("Close")) {
            lineChart.getData().add(close);
        }
        else if(value.equals("Volume")) {
            lineChart.getData().add(volume);
        }
    }
}
