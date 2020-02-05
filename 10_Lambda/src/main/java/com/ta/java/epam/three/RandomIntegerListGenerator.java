package com.ta.java.epam.three;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomIntegerListGenerator {
    private Random random = new Random();

    public List<Integer> getRandomIntegerListByInts(int count, int fromNumber, int toNumber) {
        return random.ints(count, fromNumber, toNumber).boxed().collect(Collectors.toList());
    }

    public List<Integer> getRandomIntegerListByGenerate() {
        return IntStream.generate(random::nextInt).limit(10).boxed().collect(Collectors.toList());
    }
}
