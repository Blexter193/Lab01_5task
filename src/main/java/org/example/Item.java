package org.example;

public class Item {
    private String description;
    private double weight;
    public Item(double weight, String description) {
        if (weight < 0)
            throw new IllegalArgumentException("weight must be >0.");;
        this.weight = weight;
        if (description.length() > 1) {
            this.description = description;
        } else this.description = "No description";
    }
    public double getWeight(){
        return weight;
    }
    public String getDescription(){
        return description;
    }
}
