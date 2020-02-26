package arrays.d_game;

public class Door {
    private String type;
    private int power;

    public Door(String type, int power) {
        this.type = type;
        this.power = power;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Door{" +
                "type='" + type + '\'' +
                ", power=" + power +
                '}';
    }
}
