/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reference;


public class Product {
    private int id;
    private String name;
    private int price;
    private int ammount;

    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ammount = stock;
    }
    
    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.ammount = stock;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getStock() {
        return ammount;
    }
    public void setStock(int stock) {
        this.ammount = stock;
    }
}
