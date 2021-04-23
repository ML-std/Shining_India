package com.example.shiningindia.Menu;

import java.io.Serializable;

public class MenuItem implements Serializable {

    private final int imageResource;
    private final double price;
    private final String name;
    private final String menuContent;
    private int quantity;


    MenuItem(int imageResource, String name, String menuContent, double price){
        this.imageResource = imageResource;
        this.name = name;
        this.menuContent = menuContent;
        this.price = price;
        quantity = 1;// Default quantity is 1
    }


    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public String getMenuContent() {
        return menuContent;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
