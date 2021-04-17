package com.example.shiningindia.Menu;

public class MenuItem {

    private int imageResource;
    private String price;
    private String name;
    private String menuContent;


    MenuItem(int imageResource, String name, String menuContent, String price){
        this.imageResource = imageResource;
        this.name = name;
        this.menuContent = menuContent;
        this.price = price;

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

    public String getPrice(){
        return price;
    }

}
