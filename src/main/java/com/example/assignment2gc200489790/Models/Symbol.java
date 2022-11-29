/**
 * Name : Arin Dhiman
 * Student no. : 200489790
 * Date : 27 November 2022
 * Description : this class is used to allow the functioning of file reading writing using GSON
 */

package com.example.assignment2gc200489790.Models;

public class Symbol {
    private String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * return the selected symbol when toString is called for this class
     */
    @Override
    public String toString() {
        return symbol;
    }
}
