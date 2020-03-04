package part_one.models.pizza_recipe;

import part_one.models.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheesePizzaRecipe implements PizzaRecipe {
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
        List<String> myToppings = Arrays.asList("Mushrooms", "Onions", "Green peppers", "Pineapple");
        pizza.setToppings(new ArrayList<>(myToppings));
    }

    @Override
    public void addMeat() {
        pizza.setBacon("Uncured Belly Rashers(bara)");
        pizza.setPepperoni("Peppers Pepperoni");
    }

    @Override
    public void addCheese() {
        pizza.setCheese("Mozzarella with Extra Cheese: Cheddar, Provolone, Grated Parmesan");
    }

    @Override
    public void putPizzaInOven() throws InterruptedException {
        System.out.println("Final 10-sec baking of cheese pizza...");
        oven.setTimer(10);
    }

    public Pizza takeOutPizzaFromOven() {
        return pizza;
    }
}
