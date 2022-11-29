/**
 * Name : Arin Dhiman
 * Student no. : 200489790
 * Date : 27 November 2022
 * Description : A java class for the sole purpose of mapping it to the response
 *               from the API in order to parse it into valid java object
 */

package com.example.assignment2gc200489790.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class APIResponse {
    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (5min)")
    private Map<String, StockDetail> timeSeries;

    /**
     * overloaded constructor just in case
     */
    public APIResponse(MetaData metaData, Map<String, StockDetail> timeSeries) {
        this.metaData = metaData;
        this.timeSeries = timeSeries;
    }

    public APIResponse() {}

    /**
     * getters and setters for every instance variable
     */
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

    /**
     * toString method to return a nice string representation of this object
     */
    @Override
    public String toString() {
        return "APIResponse{" +
                "metaData=" + metaData +
                ", timeSeries=" + timeSeries +
                '}';
    }
}
