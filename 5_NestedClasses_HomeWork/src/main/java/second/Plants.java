package second;

public class Plants {
	private int size;
	private Color color;
	private Type type;

	public Plants(int size, Color color, Type type) {
		this.size = size;
		this.color = color;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Size of Plants: " + size + ", Color of plants: " + color + ", Type of plants: " + type;
	}

}
