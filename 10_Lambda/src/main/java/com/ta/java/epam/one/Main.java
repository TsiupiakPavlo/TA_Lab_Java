package com.ta.java.epam.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ThreeInt maxValThreeInt = (a, b, c) -> {
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            return Collections.max(list);
        };
        System.out.println(maxValThreeInt.func(10, 15, 20));

        ThreeInt averageInt = (a, b, c) -> {
            return (a + b + c) / 3;
        };
        System.out.println(averageInt.func(10, 15, 20));
    }
}
