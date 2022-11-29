/**
 * Name : Arin Dhiman
 * Student no. : 200489790
 * Date : 27 November 2022
 * Description : A class for retaining the selection made in the index.fxml for seeing
 *               stock details, and allowing the StocksController to r4ead the selection
 *               and get the right data
 */

package com.example.assignment2gc200489790;

public class Setting {
    private static String symbol;

    public static String getSymbol() {
        return symbol;
    }

    public static void setSymbol(String symbol) {
        Setting.symbol = symbol;
    }
}
