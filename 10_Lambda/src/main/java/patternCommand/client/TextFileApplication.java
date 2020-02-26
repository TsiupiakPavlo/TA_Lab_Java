package patternCommand.client;

import patternCommand.command.*;
import patternCommand.invoker.TextFileOperationExecutor;
import patternCommand.receiver.TextFile;

public class TextFileApplication {
    public static void main(String[] args) {
        TextFileOperation openTextFileOperation = new OpenTextFileOperation(new TextFile("file1.txt"));
        TextFileOperation saveTextFileOperation = new SaveTextFileOperation(new TextFile("file2.txt"));
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

        System.out.println(textFileOperationExecutor.executeOperation(openTextFileOperation));
        System.out.println(textFileOperationExecutor.executeOperation(saveTextFileOperation));

        System.out.println(textFileOperationExecutor.executeOperation(() -> "Opening file (lambda) file1.txt"));
        System.out.println(textFileOperationExecutor.executeOperation(() -> "Saving file (lambda) file2.txt"));

        TextFile textFile = new TextFile("file.txt");
        System.out.println(textFileOperationExecutor.executeOperation(textFile::open));
        System.out.println(textFileOperationExecutor.executeOperation(textFile::save));
    }
}
