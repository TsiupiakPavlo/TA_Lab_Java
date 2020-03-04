package controller;

import model.Sites;

import java.util.ArrayList;

public class Collection {
    private static Collection instance;
    private static ArrayList<Sites> arrayList;

    private Collection() {
        arrayList = new ArrayList<>();
    }

    public static synchronized Collection getInstance() {
        if (instance == null) {
            instance = new Collection();
        }
        return instance;
    }

    public static synchronized void clear() {
        arrayList.clear();
    }

    public static synchronized void add(Sites site) {
        arrayList.add(site);
    }

    public static synchronized ArrayList<Sites> getArrayList() {
        return arrayList;
    }

}
