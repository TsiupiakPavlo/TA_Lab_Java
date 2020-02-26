package entity.santekhnika.zmishucavhi;

public class ZmishuvachiKukhnia extends Zmishuvachi {

    private String podvodka;

    public ZmishuvachiKukhnia(String name, int price, String brandCountry, int guarantee, String mechanism, String podvodka) {
        super(name, price, brandCountry, guarantee, mechanism);
        this.podvodka = podvodka;
    }

    public String getPodvodka() {
        return podvodka;
    }
}
