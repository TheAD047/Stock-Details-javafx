/**
 * Name : Arin Dhiman
 * Student no. : 200489790
 * Date : 27 November 2022
 * Description : This class is the representation for the value part
 *               of the TimeSeries Map from API response
 */

package com.example.assignment2gc200489790.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockDetail {
    @JsonProperty("1. open")
    private String open;

    @JsonProperty("2. high")
    private String high;

    @JsonProperty("3. low")
    private String low;

    @JsonProperty("4. close")
    private String close;

    @JsonProperty("5. volume")
    private String volume;

    /**
     * overloaded constructor just in case
     */
    public StockDetail(String open, String high, String low, String close, String volume) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public StockDetail () {}

    /**
     * getter and setter method for each instance variable
     */
    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * toString method to return a nice string representation of this object
     */
    @Override
    public String toString() {
        return "StockDetail{" +
                "open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
