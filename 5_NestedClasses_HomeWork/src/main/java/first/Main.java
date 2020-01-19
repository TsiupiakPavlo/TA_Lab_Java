package first;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int squareRectangle(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Arguments cannot be negative");
        }
        return a * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter first number:");
            int numberA = scanner.nextInt();

            System.out.println("Enter second number:");
            int numberB = scanner.nextInt();

            System.out.println("The area of the rectangle is " + squareRectangle(numberA, numberB));
        } catch (InputMismatchException e) {
            System.out.println("Argument must be number");
        }

    }

}
