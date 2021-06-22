package com.gmail.chiyc88.finalproject.inherit;

public class Drink {
    String name;
    int price;
    int stocks;

    public int getPrice() {
        return price;
    }

    public int getStocks() {
        return stocks;
    }

    public void removeStocks(int bought) {
        this.stocks = stocks - bought;
    }
}
