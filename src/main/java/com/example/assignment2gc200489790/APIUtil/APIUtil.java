/**
 * Name : Arin Dhiman
 * Student no. : 200489790
 * Date : 27 November 2022
 * Description : Dedicated class to handle API and JSON related actions
 */

package com.example.assignment2gc200489790.APIUtil;

import com.example.assignment2gc200489790.Models.APIResponse;
import com.example.assignment2gc200489790.Models.StockDetail;
import com.example.assignment2gc200489790.Models.Symbol;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class APIUtil {

    /**
     * This method calls the API to retrieve the stock details of the provided @param symbol
     * It returns a Map with date and time being the key and StockDetail being the value
     */
    public static Map<String, StockDetail> getStocks(String symbol) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?symbol=" + symbol + "&function=TIME_SERIES_INTRADAY&interval=5min&output_size=compact&datatype=json"))
                    .header("X-RapidAPI-Key", "593aae5988msh32fa0c9d9f52436p1c4266jsn756a1511704b")
                    .header("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            //get the response form the API as a string
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //this object parses the JSON into JAVA objects
            ObjectMapper objectMapper = new ObjectMapper();

            //parsing and creating a new APIResponse object
            APIResponse apiResponse = objectMapper.readValue(response.body(), APIResponse.class);

            return apiResponse.getTimeSeries();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This method is used to add a new Symbol in the symbols.json file which is read during the startup of the program
     * It returns a string indicating whether the operation was successful or not depending on the issue caused
     */
    public static String addSymbol(String symbolToAdd) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?symbol=" + symbolToAdd + "&function=TIME_SERIES_INTRADAY&interval=5min&output_size=compact&datatype=json"))
                .header("X-RapidAPI-Key", "593aae5988msh32fa0c9d9f52436p1c4266jsn756a1511704b")
                .header("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        File file = new File("symbols.json");

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();

            //to check if the API gave a valid response if not it will trigger an exception
            APIResponse apiResponse = objectMapper.readValue(response.body(), APIResponse.class);

            Gson gson = new Gson();

            //write to symbols.json if it doesnt exist create a new file with the same name
            if(file.exists()) {
                Symbol[] symbols = getSymbolsForComboBox();

                for (Symbol symbol : symbols) {
                    if(symbol.getSymbol().equals(symbolToAdd)) {
                        return "Symbol Already Exists...";
                    }
                }

                Symbol[] newSymbols = new Symbol[symbols.length + 1];

                for (int i = 0; i < symbols.length; i++) {
                    newSymbols[i] = symbols[i];
                }

                newSymbols[symbols.length] = new Symbol(symbolToAdd);

                FileWriter fileWriter = new FileWriter("symbols.json");

                gson.toJson(Arrays.asList(newSymbols), fileWriter);

                fileWriter.close();

                return "Symbol Added...";
            }
            else {
                List symbols = new ArrayList<>();
                symbols.add(symbolToAdd);
                FileWriter fileWriter = new FileWriter(file);

                gson.toJson(symbols, fileWriter);

                fileWriter.close();

                return "Symbol cache created...";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Invalid Symbol";
        }

    }

    /**
     * Retrieves all the symbols from the symbols.json and return it as an Array of String
     */
    public static Symbol[] getSymbolsForComboBox() {
        try {
            File file = new File("symbols.json");

            Gson gson = new Gson();

            if(file.exists()) {
                FileReader fileReader = new FileReader("symbols.json");

                Symbol[] symbols = gson.fromJson(fileReader, Symbol[].class);

                fileReader.close();

                return symbols;
            }
            else {
                throw new FileNotFoundException("the cache doesnt exist...");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
