package serialization.model;

import java.io.Serializable;

public class Droid implements Serializable {
    private String name;
    private  transient int type;

    public Droid(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
