package com.example.assignment2gc200489790.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class APIResponse {
    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (5min)")
    private Map<String, StockDetail> timeSeries;

    public APIResponse(MetaData metaData, Map<String, StockDetail> timeSeries) {
        this.metaData = metaData;
        this.timeSeries = timeSeries;
    }

    public APIResponse() {}

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Map<String, StockDetail> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(Map<String, StockDetail> timeSeries) {
        this.timeSeries = timeSeries;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "metaData=" + metaData +
                ", timeSeries=" + timeSeries +
                '}';
    }
}
