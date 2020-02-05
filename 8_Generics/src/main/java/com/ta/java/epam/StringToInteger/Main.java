package com.ta.java.epam.StringToInteger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        try {
            list.add("String");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
