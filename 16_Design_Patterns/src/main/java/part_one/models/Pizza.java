package part_one.models;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private Size size;
    private String bacon;
    private String cheese;
    private String pepperoni;
    private List<String> toppings;
    public enum Size { NONE, PERSONAL, STANDARD, FAMILY }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setBacon(String bacon) {
        this.bacon = bacon;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setPepperoni(String pepperoni) {
        this.pepperoni = pepperoni;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = (ArrayList<String>) toppings.clone();
    }

    public int getSize() {
        int inch = 10;

        switch (this.size) {
            case PERSONAL: inch = 10; break;
            case STANDARD: inch = 14; break;
            case FAMILY:   inch = 16; break;
            default:
        }
        return inch;
    }

    public String getBacon() {
        return this.bacon;
    }

    public String getCheese() {
        return this.cheese;
    }

    public String getPepperoni() {
        return this.pepperoni;
    }

    public List<String> getToppings() {
        return this.toppings;
    }

    public String toString() {
        StringBuilder result = new StringBuilder().append(getSize()).append("-inch pizza with ")
                .append(bacon).append(" ")
                .append(cheese).append(" ")
                .append(pepperoni);
        result.append(System.lineSeparator());
        for (String topping: this.toppings) {
            result.append(" + ").append(topping).append(System.lineSeparator());
        }
        return result.toString();
    }
}
