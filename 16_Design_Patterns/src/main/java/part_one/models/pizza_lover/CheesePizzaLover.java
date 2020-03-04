package part_one.models.pizza_lover;

import part_one.models.pizza_recipe.PizzaRecipe;

public class CheesePizzaLover extends PizzaLover {

    @Override
    public void bakePizza(PizzaRecipe pizzaRecipe) throws InterruptedException {
        System.out.println("In CheesePizzaLover.bakePizza():");
        pizzaRecipe.prepareIngredients();
        System.out.println("Set oven temperature to 400.0*F");
        pizzaRecipe.setOvenTemperature(400.0);
        System.out.println("Heat the oven about 2 second...");
        pizzaRecipe.setTimeOfOvenTimer(2);

        if (pizzaRecipe.getOvenTemperature() < 300.0) {
            System.out.println("Since oven temperature less than 300.0*F, re-heat the oven for 2-sec...");
            pizzaRecipe.setTimeOfOvenTimer(2);
        }

        System.out.println("Stretching the pizza dough twice to make it STANDARD size.");
        pizzaRecipe.stretchOutDough();
        pizzaRecipe.stretchOutDough();


        pizzaRecipe.addSauce();
        pizzaRecipe.addToppings();
        pizzaRecipe.addMeat();
        System.out.println("Adding cheese twice.");
        pizzaRecipe.addCheese();
        pizzaRecipe.addCheese();
        pizzaRecipe.putPizzaInOven();
    }

}
