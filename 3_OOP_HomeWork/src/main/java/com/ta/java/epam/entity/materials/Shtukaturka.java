package com.ta.java.epam.entity.materials;

public class Shtukaturka extends Materials {

    private String type;
    private int dryingTime;

    public Shtukaturka(String name, int price, int weight, String type, int dryingTime) {
        super(name, price, weight);
        this.type = type;
        this.dryingTime = dryingTime;
    }

    public String getType() {
        return type;
    }

    public int getDryingTime() {
        return dryingTime;
    }
}
