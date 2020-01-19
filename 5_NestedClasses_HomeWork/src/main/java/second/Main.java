package second;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Plants[] plants = new Plants[] { new Plants(2500, Color.GRAY, Type.MARATTIOPSIDA),
				new Plants(30, Color.GREEN, Type.PSILOTOPSIDA), new Plants(12, Color.GREEN, Type.RHYNIOPHYTA),
				new Plants(2000, Color.GREEN, Type.CHAROPHYTA), new Plants(30, Color.GREEN, Type.HORNWORTS) };
		System.out.println(Arrays.stream(plants).map(e -> e.toString()).collect(Collectors.joining(", \n")));

		System.out.println("\n\n");

		Greenhouse greenhouse = new Greenhouse();
		greenhouse.addPlants(plants);
		System.out.println(greenhouse);

		greenhouse.removePlants(plants);
		System.out.println("\n" + greenhouse);
	}
}
