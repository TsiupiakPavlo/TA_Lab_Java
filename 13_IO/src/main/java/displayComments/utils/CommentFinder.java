package displayComments.utils;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentFinder {
    public static String getJavaSource() throws Exception {
        URL url = Thread.currentThread()
                .getContextClassLoader()
                .getResource("showComments/TestSource.java");
        return new String(Files.readAllBytes(new File(url.toURI()).toPath()));
    }

    public void showComments() throws Exception {
        String source = getJavaSource();

        Pattern pattern = Pattern.compile("(?s)/\\*(.)*?\\*/");
        Matcher matcher = pattern.matcher(source);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

//    public static void findComment(String path) {
//        List<Match> commentMatches = new ArrayList<Match>();
//
//        Pattern commentsPattern = Pattern.compile("(//.*?$)|(/\\*.*?\\*/)", Pattern.MULTILINE | Pattern.DOTALL);
//        Pattern stringsPattern = Pattern.compile("(\".*?(?<!\\\\)\")");
//
//        String text = getTextFromFile(path);
//
//        Matcher commentsMatcher = commentsPattern.matcher(text);
//        while (commentsMatcher.find()) {
//            Match match = new Match();
//            match.start = commentsMatcher.start();
//            match.text = commentsMatcher.group();
//            commentMatches.add(match);
//        }
//
//        List<Match> commentsToShow = new ArrayList<Match>();
//
//        Matcher stringsMatcher = stringsPattern.matcher(text);
//        while (stringsMatcher.find()) {
//            for (Match comment : commentMatches) {
//                if (comment.start > stringsMatcher.start() && comment.start < stringsMatcher.end())
//                    commentsToShow.add(comment);
//            }
//        }
//        for (Match comment : commentsToShow)
//            System.out.println(commentMatches.get(comment));
//    }
}
