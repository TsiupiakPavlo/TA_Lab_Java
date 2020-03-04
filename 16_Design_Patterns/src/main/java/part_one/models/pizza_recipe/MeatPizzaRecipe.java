package part_one.models.pizza_recipe;

import part_one.models.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeatPizzaRecipe implements PizzaRecipe {
    private Pizza pizza = new Pizza();
    private PrepareTips prepareTips = new PrepareTips();
    private Oven oven = new Oven();
    private Pizza.Size currentPizzaSize = Pizza.Size.NONE;

    @Override
    public void prepareIngredients() {
        prepareTips.prepareDoughTips();
    }

    @Override
    public void setOvenTemperature(double fahrenheit) {
        oven.setTemperature(fahrenheit);
    }

    @Override
    public double getOvenTemperature() {
        return oven.getTemperature();
    }

    @Override
    public void setTimeOfOvenTimer(int second) throws InterruptedException {
        oven.setTimer(second);
    }

    @Override
    public void stretchOutDough() {
        prepareTips.stretchDoughTips();
        switch (currentPizzaSize) {
            case PERSONAL: currentPizzaSize = Pizza.Size.STANDARD; break;
            case STANDARD: currentPizzaSize = Pizza.Size.FAMILY;   break;
            case FAMILY:   break;
            default:       currentPizzaSize = Pizza.Size.PERSONAL; break;
        }
        pizza.setSize(currentPizzaSize);
    }

    @Override
    public void addSauce() {
        prepareTips.addSauceTips();
    }

    @Override
    public void addToppings() {
        List<String> myToppings = Arrays.asList("Mushrooms", "Onions", "Black olives", "Pineapple");
        pizza.setToppings(new ArrayList<>(myToppings));
    }

    @Override
    public void addMeat() {
        pizza.setBacon("Roasted Peameal Bacon");
        pizza.setPepperoni("Garlic Pepperoni");
    }

    @Override
    public void addCheese() {
        pizza.setCheese("Mozzarella");
    }

    @Override
    public void putPizzaInOven() throws InterruptedException {
        System.out.println("Final 5-sec baking of meat pizza...");
        oven.setTimer(5);
    }

    public Pizza takeOutPizzaFromOven() {
        return pizza;
    }
}
