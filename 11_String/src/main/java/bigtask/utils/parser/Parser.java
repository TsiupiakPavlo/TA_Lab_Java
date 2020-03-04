package bigtask.utils.parser;

import java.io.File;

public interface Parser {
    String parsing(File file);

    String replaceTab(String text);
}
