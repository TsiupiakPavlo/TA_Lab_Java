package bigtask.model;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends Finder {
    private List<String> sentences = new ArrayList<>();

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public void printArraySentences(List<String> stringArray) {
        System.out.println("List of offers:");
        for (String string : stringArray) {
            System.out.println(string);
        }
    }
}

