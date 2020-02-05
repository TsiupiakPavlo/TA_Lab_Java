package com.ta.java.epam.three;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        RandomIntegerListGenerator generator = new RandomIntegerListGenerator();

        List<Integer> list1 = generator.getRandomIntegerListByInts(10, 0, 11);
        System.out.println(list1);

        List<Integer> list2 = generator.getRandomIntegerListByGenerate();
        System.out.println(list2);

        IntSummaryStatistics stats1 = list1.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println(stats1);

        IntSummaryStatistics stats2 = list2.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println(stats2);

        Double avarageList1 = list1.stream()
                .mapToInt((x) -> x)
                .average().getAsDouble();
        System.out.println("Avarage = " + avarageList1);
        List<Integer> result1 = list1.stream()
                .filter(x ->  x > avarageList1)
                .collect(Collectors.toList());
        System.out.println(result1);

        Double avarageList2 = list2.stream()
                .mapToInt((x) -> x)
                .average().getAsDouble();
        System.out.println("Avarage = " + avarageList2);
        List<Integer> result2 = list2.stream()
                .filter(x ->  x > avarageList1)
                .collect(Collectors.toList());
        System.out.println(result2);
    }
}
