package com.example.demo666.model;

public class Phone {
    private int id;
    private String name;
    private double price;
    private int category;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Phone(int id, String name, double price, int category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
