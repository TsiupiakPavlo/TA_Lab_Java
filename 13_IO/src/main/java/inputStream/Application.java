package inputStream;

import inputStream.utils.MyInputStream;

import java.io.IOException;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        byte[] arr = new byte[]{1, 3, 5, 7};
        try (MyInputStream inputStream = new MyInputStream(arr)){
            System.out.println(inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
