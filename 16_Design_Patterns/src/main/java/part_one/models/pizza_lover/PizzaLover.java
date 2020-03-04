package part_one.models.pizza_lover;

import part_one.models.pizza_recipe.PizzaRecipe;

public abstract class PizzaLover {
    public abstract void bakePizza(PizzaRecipe pizzaRecipe) throws InterruptedException;
}
