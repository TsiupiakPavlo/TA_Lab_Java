package bigtask.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Word extends Finder {
    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public Set<String> findByLength(List<String> checkedList, int length) {
        Set<String> fond = new LinkedHashSet<>();
        for (String word : checkedList) {
            if (word.length() == length) {
                fond.add(word);
            }
        }
        return fond;
    }

    public void printSetWords(Set<String> stringSet) {
        System.out.println("List of words in sentences:");
        for (String word : stringSet) {
            System.out.println(word);
        }
    }
}
