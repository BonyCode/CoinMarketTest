package com.example.coinmarkettest;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CoinMarketCapResponse {

    @SerializedName("data")
    private List<CryptoCurrency> data;

    public List<CryptoCurrency> getData() {
        return data;
    }

    public static class CryptoCurrency {

        private int id;
        private String name;
        private String symbol;
        private Quote quote;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }

        public Quote getQuote() {
            return quote;
        }

        public static class Quote {
            @SerializedName("USD")
            private USD usd;

            public USD getUsd() {
                return usd;
            }

            public static class USD {
                private double price;

                @SerializedName("market_cap")
                private double marketCap;

                public double getPrice() {
                    return price;
                }

                public double getMarketCap() {
                    return marketCap;
                }
            }
        }
    }
}




