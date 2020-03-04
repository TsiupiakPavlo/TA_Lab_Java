package consoleMenu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class enumMap {

    public enum Color {
        RED, BLACK, BLUE
    }

    public static void main (String[]args) throws IOException {
        System.out.println("Chose color (RED, BLUE, BLACK)");
        Scanner in = new Scanner(System.in);
        String colorName = in.nextLine().toUpperCase();

        Map<String, Color> colorMap = new HashMap<>();
        colorMap.put("RED", Color.RED);
        colorMap.put("BLUE", Color.BLUE);
        colorMap.put("BLACK", Color.BLACK);

        if (colorMap.containsKey(colorName)) {
            System.out.println("Color: " + colorMap.get(colorName));
        } else {
            System.out.println("Incorrect value");
        }

    }
}
