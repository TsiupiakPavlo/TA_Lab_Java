package com.ta.java.epam;

import java.util.ArrayList;
import java.util.List;

public class Ship<T> {
    private List<T> list = new ArrayList<>();

    public void setDroid(T t) {
        this.list.add(t);
    }

    public T getDroid(int index) {
        return list.get(index);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "list=" + list +
                '}';
    }
}
