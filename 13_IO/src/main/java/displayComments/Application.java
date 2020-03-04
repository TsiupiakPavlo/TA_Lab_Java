package displayComments;

import displayComments.utils.CommentFinder;

public class Application {
    public static void main(String[] args) {
        CommentFinder commentFinder = new CommentFinder();
        try {
            commentFinder.showComments();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
