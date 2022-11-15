package com.example.assignment2gc200489790.APIUtil;

import com.example.assignment2gc200489790.Models.APIResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtil {

    public static void getStocks(String symbol) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?symbol=" + symbol + "&function=TIME_SERIES_INTRADAY&interval=5min&output_size=compact&datatype=json"))
                    .header("X-RapidAPI-Key", "593aae5988msh32fa0c9d9f52436p1c4266jsn756a1511704b")
                    .header("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            APIResponse apiResponse = objectMapper.readValue(response.body(), APIResponse.class);
            System.out.println(apiResponse);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}