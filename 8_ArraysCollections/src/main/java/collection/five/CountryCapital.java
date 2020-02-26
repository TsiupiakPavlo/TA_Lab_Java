package collection.five;

import java.util.Comparator;

public class CountryCapital implements Comparator<CountryCapital> {
    private String country;
    private String capital;

    public CountryCapital() {
    }

    public CountryCapital(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "CountryCapital{" +
                "Country='" + country + '\'' +
                ", Capital='" + capital + '\'' +
                '}' + "\n";
    }

    @Override
    public int compare(CountryCapital o1, CountryCapital o2) {
        return o1.country.compareTo(o2.country);
    }
}
