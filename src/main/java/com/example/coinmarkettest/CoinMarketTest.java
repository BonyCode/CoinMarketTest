package com.example.coinmarkettest;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinMarketTest {

    private static final String API_KEY = "7f5521c6-ea62-4630-862e-83b49c83f5e3";

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pro-api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CoinMarketCapService service = retrofit.create(CoinMarketCapService.class);

        Call<CoinMarketCapResponse> call = service.getLatestListings(
                API_KEY,
                1,
                10,
                "USD"
        );

        try {
            Response<CoinMarketCapResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("Ответ от CoinMarketCap API (форматированный):");
                CoinMarketCapResponse responseData = response.body();
                printFormattedData(responseData);
            } else {
                System.out.println("Ошибка запроса к CoinMarketCap API.");
                if (response.errorBody() != null) {
                    System.out.println(response.errorBody().string());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFormattedData(CoinMarketCapResponse response) {
        System.out.println("=== CoinMarketCap API Response ===");
        for (CoinMarketCapResponse.CryptoCurrency currency : response.getData()) {
            System.out.println("----------------------------------");
            System.out.println("Name: " + currency.getName());
            System.out.println("Symbol: " + currency.getSymbol());
            if (currency.getQuote() != null && currency.getQuote().getUsd() != null) {
                System.out.printf("Price (USD): %.2f%n", currency.getQuote().getUsd().getPrice());
                System.out.printf("Market Cap: %.2f%n", currency.getQuote().getUsd().getMarketCap());
            } else {
                System.out.println("Price and Market Cap: N/A");
            }
            System.out.println("----------------------------------\n");
        }
    }
}







