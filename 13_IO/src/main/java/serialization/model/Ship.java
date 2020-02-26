package serialization.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ship implements Serializable {
    List<Droid> droidShip = new ArrayList<>();

    public void addDroid(Droid droid) {
        droidShip.add(droid);
    }

    public Droid removeDroid(int index) {
        droidShip.remove(index);
        return droidShip.get(index);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "droidShip=" + droidShip +
                '}';
    }
}
