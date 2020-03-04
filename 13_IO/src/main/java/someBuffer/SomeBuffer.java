package someBuffer;

import com.google.common.io.Resources;

import java.io.*;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class SomeBuffer {
    public static void copyFile(String fromFilePath, String toFilePath) throws IOException {
//        Path filePath = FileSystems.getDefault().getPath(".", fromFilePath);
//        byte[] byteArray = Files.readAllBytes(filePath);
//        Path fileCopy = FileSystems.getDefault().getPath(".", toFilePath);
//        Files.write(fileCopy, byteArray);

        URL fromPath = Resources.getResource(fromFilePath);
        File fromFile = new File(fromPath.getFile());

        byte[] byteArray = new byte[(int) fromFile.length()];
        FileInputStream fis = new FileInputStream(fromFile);
        fis.read(byteArray);
        fis.close();

        URL toPath = Resources.getResource(toFilePath);
        File toFile = new File(toPath.getFile());
        FileOutputStream fos = new FileOutputStream(toFile);
        fos.write(byteArray);
        fos.close();
    }

    public static void main(String[] args) {
        try {
            copyFile("someBuffer/from.txt", "someBuffer/to.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
