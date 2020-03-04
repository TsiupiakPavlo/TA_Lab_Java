package part_one;

import part_one.models.*;
import part_one.models.pizza_lover.CheesePizzaLover;
import part_one.models.pizza_lover.MeatPizzaLover;
import part_one.models.pizza_lover.PizzaLover;
import part_one.models.pizza_recipe.CheesePizzaRecipe;
import part_one.models.pizza_recipe.MeatPizzaRecipe;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        PizzaLover pizzaLover;
        Pizza pizza;

        pizzaLover = new MeatPizzaLover();
        MeatPizzaRecipe meatPizzaRecipe = new MeatPizzaRecipe();
        pizzaLover.bakePizza(meatPizzaRecipe);
        pizza = meatPizzaRecipe.takeOutPizzaFromOven();
        System.out.println(pizza);

        pizzaLover = new CheesePizzaLover();
        CheesePizzaRecipe cheesePizzaRecipe = new CheesePizzaRecipe();
        pizzaLover.bakePizza(cheesePizzaRecipe);
        pizza = cheesePizzaRecipe.takeOutPizzaFromOven();
        System.out.println(pizza);
    }
}
