package bigtask.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Finder {

    public List<String> findInString(String checkedString, String regex) {
        List<String> data = new ArrayList<>();
        Pattern p = Pattern.compile(regex,
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(checkedString);

        while (matcher.find()) {
            data.add(matcher.group().trim());
        }
        return data;
    }

    public List<String> findInList(List<String> checkedList, String regex) {
        List<String> data = new ArrayList<>();

        for (String checkedString : checkedList) {
            Pattern p = Pattern.compile(regex,
                    Pattern.CASE_INSENSITIVE);
            Matcher matcher = p.matcher(checkedString);

            while (matcher.find()) {
                data.add(matcher.group().trim());
            }
        }
        return data;
    }

    public String replaceInString(String checkedString, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(checkedString);
        checkedString = matcher.replaceAll("");
        return checkedString;
    }
}
