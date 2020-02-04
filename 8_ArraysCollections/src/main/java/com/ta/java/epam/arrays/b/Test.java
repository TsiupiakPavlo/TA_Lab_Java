package com.ta.java.epam.arrays.b;

import java.util.HashMap;
import java.util.Map;

public class Test {
    static void RemoveElements(int arr[]) {
        Map<Integer,Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {
            mp.put(arr[i],mp.get(arr[i]) == null?1:mp.get(arr[i])+1);
        }

        for (int i = 0; i < arr.length; ++i) {
            if (mp.containsKey(arr[i]) && mp.get(arr[i]) <= 2) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 2, 3, 3 };
        RemoveElements(arr);
    }
}

