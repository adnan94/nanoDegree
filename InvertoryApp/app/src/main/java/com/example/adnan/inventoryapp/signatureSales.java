package com.example.adnan.inventoryapp;

/**
 * Created by Adnan on 8/21/2016.
 */
public class signatureSales {
    String name;
    int sales, quantity, price, id;

    public signatureSales(String name, int sales, int quantity, int price, int id) {
        this.name = name;
        this.sales = sales;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getSales() {
        return sales;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public signatureSales(String name, int price, int quantity, int sales) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sales = sales;
    }
}
