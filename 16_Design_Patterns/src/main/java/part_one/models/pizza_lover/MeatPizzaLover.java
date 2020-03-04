package part_one.models.pizza_lover;

import part_one.models.pizza_recipe.PizzaRecipe;

public class MeatPizzaLover extends PizzaLover {

    @Override
    public void bakePizza(PizzaRecipe pizzaRecipe) throws InterruptedException {
        System.out.println("In MeatPizzaLover.bakePizza():");
        pizzaRecipe.prepareIngredients();
        System.out.println("Set oven temperature to 300.0*F");
        pizzaRecipe.setOvenTemperature(300.0);
        System.out.println("Heat the oven about 5 seconds...");
        pizzaRecipe.setTimeOfOvenTimer(5);

        if (pizzaRecipe.getOvenTemperature() < 500.0) {
            System.out.println("Since oven temperature less than 500.0*F, re-heat the oven for 2-sec...");
            pizzaRecipe.setTimeOfOvenTimer(2);
        }

        System.out.println("Stretching the pizza dough three times to make it FAMILY size.");
        pizzaRecipe.stretchOutDough();
        pizzaRecipe.stretchOutDough();
        pizzaRecipe.stretchOutDough();

        pizzaRecipe.addSauce();
        pizzaRecipe.addToppings();
        System.out.println("Adding meat twice.");
        pizzaRecipe.addMeat();
        pizzaRecipe.addMeat();
        pizzaRecipe.addCheese();
        pizzaRecipe.putPizzaInOven();
    }

}
