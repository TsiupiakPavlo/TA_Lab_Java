package part_one.models.pizza_recipe;

public class Oven {
    private double temperature;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTimer(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
        System.out.println("Ding!");
    }
}
