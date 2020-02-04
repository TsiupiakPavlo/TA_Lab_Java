package com.ta.java.epam.arrays.b;

import org.apache.commons.lang3.*;

public class Main {
    /*public static int[] deleteSecondRepeat(int[] elements) {
        int[] times = new int[elements.length];
        int result;
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (elements[i] == elements[j]) {
                    times[i]++;
                    if (times[i] > 2) {
                        System.arraycopy(elements, j + 1, elements, j, elements.length - 1 - j);
                    }
                }
            }
        }
        return elements;
    }*/

    public static int[] deleteSecondRepeat(int[] array) {
        for(int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] == array[j]) {
                    array = ArrayUtils.remove(array, j);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] tmp = {1, 1, 2, 2, 2, 3};
        int[] res = deleteSecondRepeat(tmp);
        for (int temp : res) {
            System.out.print(temp + " ");
        }
    }
}
