package com.example.shiningindia.Order;

import com.example.shiningindia.Menu.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;

public  class Cart implements Serializable {
    public  ArrayList<MenuItem> items;

    public Cart(){
        items = new ArrayList<>();
    }
    public  void addToCart(MenuItem item){
        items.add(item);
    }

    public  String removeFromCart(int index){

        return items.remove(index).getName();
    }

    public  void removeAll(){
        items.clear();
    }

    public int size(){
        return this.items.size();
    }
}
