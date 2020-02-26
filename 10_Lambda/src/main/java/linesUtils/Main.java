package linesUtils;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String input;
        do{
            input = new Scanner(System.in).nextLine();
            list.add(input);
        }while (input.length()!=0);

        String line = String.join(" ", list).trim();
        System.out.println(line);

        list = Arrays.asList(line.split(" "));

        //Task 1
        long countUniqueWords = list.stream().filter(t -> t.matches("[a-zA-z]+")).distinct().count();
        System.out.println("Unique words = " + countUniqueWords);

        //Task 2
        List<String> uniqueWords = list.stream().filter(t -> t.matches("[a-zA-z]+")).distinct().collect(toList());
        System.out.println(uniqueWords);

        //Task 3
        Map<String, Integer> frequencyMap = list.stream()
                .collect(toMap(
                        s -> s,
                        s -> 1,
                        Integer::sum));
        System.out.println("Frequency of words = " + frequencyMap);

        //Task 4
        List<String> symbols = Arrays.asList(line.split(""));
        Map<String, Integer> frequencyMapSymbols = symbols.stream()
                .filter(s -> s.matches("[a-z]+"))
                .collect(toMap(
                        s -> s,
                        s -> 1,
                        Integer::sum));
        System.out.println("Frequency of symbols except upper case = " + frequencyMapSymbols);
    }
}
