package bigtask.utils.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileParsing implements Parser {
    private String text;

    @Override
    public String parsing(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        text = new String(stringBuilder);
        return text;
    }

    @Override
    public String replaceTab(String text) {
        Pattern p = Pattern.compile("\\s{2,}");
        Matcher matcher = p.matcher(text);
        this.text = matcher.replaceAll(" ");

        Pattern p2 = Pattern.compile("¬");
        Matcher matcher2 = p2.matcher(this.text);
        this.text = matcher2.replaceAll("");
        return this.text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
