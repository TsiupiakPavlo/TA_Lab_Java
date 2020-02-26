public class Droid implements Comparable<Droid> {
    String name;

    public Droid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                '}';
    }

    public int compareTo(Droid o) {
        return this.name.compareTo(o.name);
    }
}
