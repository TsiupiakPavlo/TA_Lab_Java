package second;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Plants[] plants = new Plants[] { new Plants(1, Color.YELLOW, Type.ALGAE),
				new Plants(2, Color.BLUE, Type.CONIFERS), new Plants(3, Color.GREEN, Type.FERNS),
				new Plants(4, Color.RED, Type.CYCADS), new Plants(5, Color.WHITE, Type.GINKGO) };

		for (Plants tmp: plants) {
			System.out.println(tmp);
		}
	}
}
