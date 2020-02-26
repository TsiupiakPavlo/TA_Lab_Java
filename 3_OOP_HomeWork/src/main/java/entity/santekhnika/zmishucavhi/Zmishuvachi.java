package entity.santekhnika.zmishucavhi;

import Code;
import entity.santekhnika.Santekhnika;

public abstract class Zmishuvachi extends Santekhnika implements Code {

    protected String mechanism;

    public Zmishuvachi(String name, int price, String brandCountry, int guarantee, String mechanism) {
        super(name, price, brandCountry, guarantee);
        this.mechanism = mechanism;
    }

    public String getMechanism() {
        return mechanism;
    }

    public int getCode() {
        return (int)(Math.random() * 1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zmishuvachi)) return false;

        Zmishuvachi that = (Zmishuvachi) o;

        return getMechanism() != null ? getMechanism().equals(that.getMechanism()) : that.getMechanism() == null;
    }

    @Override
    public int hashCode() {
        return getMechanism() != null ? getMechanism().hashCode() : 0;
    }
}
