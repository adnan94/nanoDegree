package com.example.adnan.inventoryapp;

/**
 * Created by Adnan on 8/21/2016.
 */
public class signatureProducts {
    String name;
    int quantity;
    int id;
    int price;

    public signatureProducts(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public signatureProducts(String name, int quantity, int id, int price) {
        this.name = name;
        this.quantity = quantity;

        this.id = id;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {

        return name;
    }
}
