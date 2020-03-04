package part_one.models.pizza_recipe;

public interface PizzaRecipe {
    void prepareIngredients();
    void setOvenTemperature(double fahrenheit);
    double getOvenTemperature();
    void setTimeOfOvenTimer(int second) throws InterruptedException;
    void stretchOutDough();
    void addSauce();
    void addToppings();
    void addMeat();
    void addCheese();
    void putPizzaInOven() throws InterruptedException;
}
