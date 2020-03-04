package entity.santekhnika;

public class Vanna extends Santekhnika {

    private String form;
    private ColorOfVanna colorOfVanna;

    public Vanna(String name, int price, String brandCountry, int guarantee, String form, ColorOfVanna colorOfVanna) {
        super(name, price, brandCountry, guarantee);
        this.form = form;
        this.colorOfVanna = colorOfVanna;
    }

    public String getForm() {
        return form;
    }

    public  ColorOfVanna getColorOfVanna() {
        return colorOfVanna;
    }
}
