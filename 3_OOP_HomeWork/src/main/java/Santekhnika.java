abstract class Santekhnika extends Goods{

    String brandCountry;
    int guarantee;

    public Santekhnika(String name, int price, String brandCountry, int guarantee) {
        this.name = name;
        this.price = price;
        this.brandCountry = brandCountry;
        this.guarantee = guarantee;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public int getGuarantee() {
        return guarantee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Santekhnika)) return false;

        Santekhnika that = (Santekhnika) o;

        if (getGuarantee() != that.getGuarantee()) return false;
        return getBrandCountry() != null ? getBrandCountry().equals(that.getBrandCountry()) : that.getBrandCountry() == null;
    }

    @Override
    public int hashCode() {
        int result = getBrandCountry() != null ? getBrandCountry().hashCode() : 0;
        result = 31 * result + getGuarantee();
        return result;
    }
}
