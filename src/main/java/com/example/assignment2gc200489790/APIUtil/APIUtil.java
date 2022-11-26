package com.example.assignment2gc200489790.APIUtil;

import com.example.assignment2gc200489790.Models.APIResponse;
import com.example.assignment2gc200489790.Models.StockDetail;
import com.example.assignment2gc200489790.Models.Symbol;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class APIUtil {

    public static Map<String, StockDetail> getStocks(String symbol) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?symbol=" + symbol + "&function=TIME_SERIES_INTRADAY&interval=5min&output_size=compact&datatype=json"))
                    .header("X-RapidAPI-Key", "593aae5988msh32fa0c9d9f52436p1c4266jsn756a1511704b")
                    .header("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            APIResponse apiResponse = objectMapper.readValue(response.body(), APIResponse.class);

            return apiResponse.getTimeSeries();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
            APIResponse apiResponse = objectMapper.readValue(response.body(), APIResponse.class);

            Gson gson = new Gson();

            if(file.exists()) {
                List<Symbol> symbols = getSymbols();

                if(symbols.contains(new Symbol(symbolToAdd))) {
                    symbols.add(new Symbol(symbolToAdd));

                    System.out.println(gson.toJson(symbols, ArrayList.class));

                    FileWriter fileWriter = new FileWriter(file);

                    fileWriter.write(gson.toJson(symbols, ArrayList.class));

                    fileWriter.close();

                    return "Symbol added...";
                }
                else {
                    return "Symbol already Exists...";
                }

            }
            else {
                List symbols = new ArrayList<>();
                symbols.add(symbolToAdd);
                FileWriter fileWriter = new FileWriter(file);

                gson.toJson(symbols, fileWriter);

                return "Symbol cache created...";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Invalid Symbol";
        }

    }

    public static List<Symbol> getSymbols() {
        try {
            File file = new File("symbols.json");

            Gson gson = new Gson();

            if(file.exists()) {
                FileReader fileReader = new FileReader("symbols.json");

                List<Symbol> symbols = gson.fromJson(fileReader, List.class);

                fileReader.close();

                return symbols;
            }
            else {
                return null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
                return null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
