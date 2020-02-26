package entity.materials;

import entity.Goods;

abstract class Materials extends Goods {

    int weight;

    Materials(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materials)) return false;

        Materials materials = (Materials) o;

        return getWeight() == materials.getWeight();
    }

    @Override
    public int hashCode() {
        return getWeight();
    }
}
