package com.example.assignment2gc200489790.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaData {
    @JsonProperty("1. Information")
    private String info;

    @JsonProperty("2. Symbol")
    private String symbol;

    @JsonProperty("3. Last Refreshed")
    private String refreshedOn;

    @JsonProperty("4. Interval")
    private String intervalTime;

    @JsonProperty("5. Output Size")
    private String outputSize;

    @JsonProperty("6. Time Zone")
    private String timeZone;

    public MetaData(String info, String symbol, String refreshedOn, String intervalTime, String outputSize, String timeZone) {
        this.info = info;
        this.symbol = symbol;
        this.refreshedOn = refreshedOn;
        this.intervalTime = intervalTime;
        this.outputSize = outputSize;
        this.timeZone = timeZone;
    }

    public MetaData() {}

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRefreshedOn() {
        return refreshedOn;
    }

    public void setRefreshedOn(String refreshedOn) {
        this.refreshedOn = refreshedOn;
    }

    public String getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getOutputSize() {
        return outputSize;
    }

    public void setOutputSize(String outputSize) {
        this.outputSize = outputSize;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "info='" + info + '\'' +
                ", symbol='" + symbol + '\'' +
                ", refreshedOn='" + refreshedOn + '\'' +
                ", intervalTime='" + intervalTime + '\'' +
                ", outputSize='" + outputSize + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}

