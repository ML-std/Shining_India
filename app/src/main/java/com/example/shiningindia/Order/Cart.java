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

    public void removeFromCart(int index){
        items.remove(index);
    }

    public  void removeAll(){
        items.clear();
    }

    public int size(){
        return this.items.size();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }
}
