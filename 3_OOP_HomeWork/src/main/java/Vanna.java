class Vanna extends Santekhnika {

    private String form;
    private ColorOfVanna colorOfVanna;

    Vanna(String name, int price, String brandCountry, int guarantee, String form, ColorOfVanna colorOfVanna) {
        super(name, price, brandCountry, guarantee);
        this.form = form;
        this.colorOfVanna = colorOfVanna;
    }

    public String getForm() {
        return form;
    }
}
