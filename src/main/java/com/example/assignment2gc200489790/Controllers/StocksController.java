/**
 * Name : Arin Dhiman
 * Student no. : 200489790
 * Date : 27 November 2022
 * Description : This class controller class is used to handle the stocks.fxml file
 */

package com.example.assignment2gc200489790.Controllers;

import com.example.assignment2gc200489790.APIUtil.APIUtil;
import com.example.assignment2gc200489790.Models.StockDetail;
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

    //instance variables for chart data
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

    /**
     * this method is triggered when btnForMainMenu is clicked
     * it loads the index.fxml file
     */
    @FXML
    void backToMainMenu(ActionEvent event) throws Exception{
        SceneController.changeScene(event, "Index");
    }

    /**
     * overriding the initialize method
     * it primes several elements of the scene for displaying the appropriate data in a presentable manner
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelForTitle.setText("Stock Info for " + Setting.getSymbol());

        //prime the combobox
        comboBoxForCategory.getItems().addAll("Open", "High", "Low", "Close", "Volume");

        //to avoid graphical artifacts
        comboBoxForCategory.setValue("Open");
        updateChart(new ActionEvent());

        //get the data for the selected symbol
        Map<String, StockDetail> map = APIUtil.getStocks(Setting.getSymbol());

        open.setName("Open");
        high.setName("High");
        low.setName("Low");
        close.setName("Close");
        volume.setName("Volume");

        //assign the correct values to correct chart data
        map.keySet().forEach(key -> {
            volume.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getVolume()) / 10));
            open.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getOpen())));
            high.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getHigh())));
            low.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getLow())));
            close.getData().add(new XYChart.Data<String, Double>(key, Double.parseDouble(map.get(key).getClose())));
        });
    }

    /**
     * this method triggers when a new value is selected in the combobox
     * it updates the line chart according to the selected value
     * the value is to determine which category of data needs to be displayed
     */
    @FXML
    void updateChart(ActionEvent event) {
        String value = comboBoxForCategory.getValue();

        //clear the data
        lineChart.getData().remove(0, lineChart.getData().size());

        //populate the chart with the correct data
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
