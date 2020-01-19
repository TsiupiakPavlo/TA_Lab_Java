package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int squareRectangle(int a, int b) {
		if (a < 0 || b < 0)
			throw new IllegalArgumentException("Arguments cannot be negative");
		return a * b;
	}

	public static void main(String[] args) {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Enter first number:");
			int number1 = Integer.parseInt(bufferedReader.readLine());

			System.out.println("Enter second number:");
			int number2 = Integer.parseInt(bufferedReader.readLine());

			System.out.println("The area of the rectangle is " + squareRectangle(number1, number2));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Nonnumeric value");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
