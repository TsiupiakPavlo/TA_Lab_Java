package second;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Greenhouse {
	private TreeSet<Plants> plants = new TreeSet<Plants>(
			Comparator.comparing(Plants::getTypeString).thenComparing(Plants::getId));

	public void addPlants(Plants[] plants) {
		for (Plants plant : plants) {
			this.addPlant(plant);
		}
	}

	public void addPlant(Plants plant) {
		try {
			checkPlant(plant);
			System.out.println("Add new plant " + plant);
			this.plants.add(plant);
		} catch (TypeException e) {
			System.out.println("\nCannot add " + plant + ". " + e.getMessage() + "\n");
		} catch (ColorException e) {
			System.out.println("\n" + e.getMessage() + "(" + plant + ")");
		}
	}

	public void removePlants(Plants[] plants) {
		System.out.println("\nTry to remove plants\n");
		this.plants.removeAll(Arrays.stream(plants).collect(Collectors.toSet()));
	}

	public void removePlant(Plants plants) {
		System.out.println("\nTry to remove plant\n");
		this.plants.remove(plants);
	}

	public void checkPlant(Plants plant) throws TypeException, ColorException {
		if (plant.getColor().name().equalsIgnoreCase("gray"))
			throw new ColorException("The owner's wife doesn't like a gray color.");
		checkIfNotExtinctPlants(plant);
	}

	public void checkIfNotExtinctPlants(Plants plant) throws TypeException {
		if (plant.getTypeString().equalsIgnoreCase("Rhyniophyta")
				|| plant.getTypeString().equalsIgnoreCase("Zosterophyllophyta")
				|| plant.getTypeString().equalsIgnoreCase("Trimerophytophyta"))
			throw new TypeException("This plant is already extinct");
	}

	@Override
	public String toString() {
		if (this.plants.size() > 0)
			return "\nGreenhouse: \n" + plants.stream().map(e -> e.toString()).collect(Collectors.joining(", \n"));
		return "\nGreenhouse is empty\n";
	}
}
