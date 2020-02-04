package com.ta.java.epam.collection.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<CountryCapital>();
        CountryCapital[] arr = new CountryCapital[10];
        for (int i = 9; i > 0; i--) {
            list.add(new CountryCapital("" + i, "" + (i + 100)));
            arr[i] = new CountryCapital("" + i, "" + (i + 100));
        }

        System.out.println("Unsorted list");
        System.out.println(list);

        System.out.println("Unsorted array");
        System.out.println(Arrays.asList(arr));

        System.out.println("Sorted list");
        list.sort(new CountryCapital());
        System.out.println(list);

        System.out.println("Sorted array");
        Arrays.sort(arr, new Comparator<CountryCapital>() {
            @Override
            public int compare(CountryCapital o1, CountryCapital o2) {
                return o1.getCountry().compareTo(o2.getCountry());
            }
        });
        System.out.println(Arrays.asList(arr));

    }
}
