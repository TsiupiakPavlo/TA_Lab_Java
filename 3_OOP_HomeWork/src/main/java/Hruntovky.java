public class Hruntovky extends Materials {

    private String type;
    private String basisOfMixture;

    Hruntovky(String name, int price, int weight, String type, String basisOfMixture) {
        super(name, price, weight);
        this.type = type;
        this.basisOfMixture = basisOfMixture;
    }

    public String getType() {
        return type;
    }

    public String getBasisOfMixture() {
        return basisOfMixture;
    }
}
