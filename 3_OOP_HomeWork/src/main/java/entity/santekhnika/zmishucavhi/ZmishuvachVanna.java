package entity.santekhnika.zmishucavhi;

public class ZmishuvachVanna extends Zmishuvachi {

    private String montag;

    public ZmishuvachVanna(String name, int price, String brandCountry, int guarantee, String mechanism, String montag) {
        super(name, price, brandCountry, guarantee, mechanism);
        this.montag = montag;
    }

    public String getMontag() {
        return montag;
    }
}
