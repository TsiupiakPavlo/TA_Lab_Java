public class Rakoviny extends Santekhnika implements Code {

    private String montag;

    public Rakoviny(String name, int price, String brandCountry, int guarantee, String montag) {
        super(name, price, brandCountry, guarantee);
        this.montag = montag;
    }

    public int getCode() {
        return 0;
    }
}
